package battle;

import java.awt.Point;
import java.util.Scanner;


public class Board {
    private static final Ship[] ships;
    private char[][] board;

    /**
     * Initialize ships (once).
     *
     */

    static {
        ships = new Ship[]{
            new Ship("Carrier", Constants.SIZE_CARRIER),
            new Ship("Battleship", Constants.SIZE_BATTLESHIP),
            new Ship("Cruiser", Constants.SIZE_CRUISER),
            new Ship("Submarine", Constants.SIZE_SUBMARINE),
            new Ship("Destroyer", Constants.SIZE_DESTROYER)
        };
    }


    /**
     * Constructor
     */
    public Board() {
        board = new char[Constants.BOARD_SIZE][Constants.BOARD_SIZE];

        for(int i = 0; i < Constants.BOARD_SIZE; i++) {
            for(int j = 0; j < Constants.BOARD_SIZE; j++) {
                board[i][j] = Constants.ICON_BOARD;
            }
        }

        placeShipsOnBoard();
    }


    /**
     * Target ship ship.
     *
     * @param point the point
     * @return ship
     */
    public Ship targetShip(Point point) {
        boolean isHit = false;
        Ship hitShip = null;
        for(int i = 0; i < ships.length; i++) {
            Ship ship = ships[i];
            if(ship.getPosition() != null) {
                if(Utils.isPointBetween(point, ship.getPosition())) {
                    isHit = true;
                    hitShip = ship;
                    break;
                }

            }
        }
        final char result = isHit ? Constants.ICON_SHIP_IS_HIT : Constants.ICON_SHOT_MISSED;
        updateShipOnBoard(point, result);
        printBoard();

        return (isHit) ? hitShip : null;
    }

    /**
     * Place ships on board.
     */
    private void placeShipsOnBoard() {
        System.out.printf("%nAlright - Time to place out your ships%n%n");
        Scanner s = new Scanner(System.in);

        for(int i = 0; i < ships.length; i++) {
            Ship ship = ships[i];
            boolean isShipPlacementLegal = false;

            System.out.printf("%nEnter position of %s (length  %d): ", ship.getName(), ship.getSize());

            while(!isShipPlacementLegal) {
                try {
                    Point from = new Point(s.nextInt(), s.nextInt());
                    Point to = new Point(s.nextInt(), s.nextInt());

                    while(ship.getSize() != Utils.distanceBetweenPoints(from, to)) {
                        System.out.printf("The ship currently being placed on the board is of length: %d. Change your coordinates and try again",
                            ship.getSize());

                        from = new Point(s.nextInt(), s.nextInt());
                        to = new Point(s.nextInt(), s.nextInt());
                    }
                    Position position = new Position(from, to);

                    if(!isPositionOccupied(position)) {
                        drawShipOnBoard(position);
                        ship.setPosition(position);
                        isShipPlacementLegal = true;
                    } else {
                        System.out.println("A ship in that position already exists - try again");
                    }

                } catch(IndexOutOfBoundsException e) {
                    System.out.println("Invalid coordinates - Outside board");
                }
            }
        }

    }


    private void updateShipOnBoard(Point point, final char result) {
        int x = (int) point.getX() - 1;
        int y = (int) point.getY() - 1;
        board[y][x] = result;
    }

    /**
     *
     * @param position
     * @return
     */
    private boolean isPositionOccupied(Position position) {
        boolean isOccupied = false;
        Point from = position.from();
        Point to = position.to();

        outer:
        for(int i = (int) from.getY() - 1; i < to.getY(); i++) {
            for(int j = (int) from.getX() - 1; j < to.getX(); j++) {
                if(board[i][j] == Constants.ICON_SHIP) {
                    isOccupied = true;
                    break outer;
                }
            }
        }


        return isOccupied;
    }

    /**
     *
     * @param position
     */
    private void drawShipOnBoard(Position position) {
        Point from = position.from();
        Point to = position.to();
        for(int i = (int) from.getY() - 1; i < to.getY(); i++) {
            for(int j = (int) from.getX() - 1; j < to.getX(); j++) {
                board[i][j] = Constants.ICON_SHIP;
            }
        }
        printBoard();
    }


    /**
     * Print board.
     */
    private void printBoard() {
        System.out.print("\t");

        for(int i = 0; i < Constants.BOARD_SIZE; i++) {
            System.out.print(Constants.BOARD_LETTERS[i] + "\t");
        }

        System.out.println();

        for(int i = 0; i < Constants.BOARD_SIZE; i++) {
            System.out.print((i+1) + "\t");
            for(int j = 0; j < Constants.BOARD_SIZE; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
    }

}

