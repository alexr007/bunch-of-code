package battle;

import java.awt.Point;

public class Position {
    private Point from;
    private Point to;

    /**
     * Instantiates a new Position.
     *
     * @param from the from
     * @param to   the to
     */
    public Position(Point from, Point to) {
        if(from.getX() > Constants.BOARD_SIZE || from.getX() < 0
            || from.getY() > Constants.BOARD_SIZE || from.getY() < 0
            || to.getX() > Constants.BOARD_SIZE || to.getX() < 0
            || to.getY() > Constants.BOARD_SIZE || to.getY() < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }

        this.from = from;
        this.to = to;
    }

    /**
     * Gets from.
     *
     * @return the from
     */
    public Point from() {
        return from;
    }

    /**
     * Gets to.
     *
     * @return the to
     */
    public Point to() {
        return to;
    }
}