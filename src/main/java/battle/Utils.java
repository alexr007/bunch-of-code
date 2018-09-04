package battle;


import java.awt.Point;


class Utils {

    private Utils() {

    }

    /**
     * Distance between points double.
     *
     * @param from the from
     * @param to   the to
     * @return the double
     */
    public static double distanceBetweenPoints(Point from, Point to) {
        double x1 = from.getX();
        double y1 = from.getY();
        double x2 = to.getX();
        double y2 = to.getY();
        return Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2)) + 1;
    }


    /**
     * Is point between boolean.
     *
     * @param point    the point
     * @param position the position
     * @return the boolean
     */
    public static boolean isPointBetween(Point point, Position position) {
        Point from = position.from();
        Point to = position.to();
        return from.getY() <= point.getY()
            && to.getY() >= point.getY()
            && from.getX() <= point.getX()
            && to.getX() >= point.getX();
    }

}
