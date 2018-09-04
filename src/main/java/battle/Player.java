package battle;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Player {
    private int id;
    private int lives;
    private Board board;
    private Map<Point, Boolean> targetHistory;
    private Scanner scanner;

    /**
     * Instantiates a new Player.
     *
     * @param id the id
     */
    public Player(int id) {
        System.out.printf("%n=== Setting up everything for Player %s ====", id);
        this.id = id;
        this.lives = Constants.PLAYER_LIVES;
        this.board = new Board();
        this.targetHistory = new HashMap<>();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Gets lives.
     *
     * @return the lives
     */
    public int getLives() {
        return lives;
    }

    /**
     * Decrement live by one.
     */
    public void decrementLiveByOne() {
        lives--;
    }

    /**
     * Turn to play.
     *
     * @param opponent the opponent
     */
    public void turnToPlay(Player opponent) {
        System.out.printf("%n%nPlayer %d, Choose coordinates you want to hit (x y) ", id);
        Point point = new Point(scanner.nextInt(), scanner.nextInt());

        while(targetHistory.get(point) != null) {
            System.out.print("This position has already been tried");
            point = new Point(scanner.nextInt(), scanner.nextInt());
        }

        attack(point, opponent);
    }

    /**
     * Attack
     *
     * @param point
     * @param opponent
     */
    private void attack(Point point, Player opponent) {
        Ship ship = opponent.board.targetShip(point);
        boolean isShipHit = (ship != null) ? true : false;

        if(isShipHit) {
            ship.shipWasHit();
            opponent.decrementLiveByOne();
        }
        targetHistory.put(point, isShipHit);
        System.out.printf("Player %d, targets (%d, %d)",
            id,
            (int)point.getX(),
            (int)point.getY());
        System.out.println("...and " + ((isShipHit) ? "HITS!" : "misses..."));
    }
}
