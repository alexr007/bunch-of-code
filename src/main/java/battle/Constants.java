package battle;

class Constants {
    private Constants() {}

    static final int SIZE_CARRIER = 5;
    static final int SIZE_BATTLESHIP = 4;
    static final int SIZE_CRUISER = 3;
    static final int SIZE_SUBMARINE = 3;
    static final int SIZE_DESTROYER = 2;

    static final int PLAYER_LIVES = SIZE_CARRIER + SIZE_BATTLESHIP
                                + SIZE_CRUISER + SIZE_SUBMARINE + SIZE_DESTROYER;

    static final char ICON_SHIP = 'X';
    static final char ICON_BOARD = '-';
    static final char ICON_SHIP_IS_HIT = 'O';
    static final char ICON_SHOT_MISSED = 'M';

    static final char[] BOARD_LETTERS = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
    static final int BOARD_SIZE = 10;
}
