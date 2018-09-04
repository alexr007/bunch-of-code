package battle;

public class Game {
    private Player[] players;

    /**
     * Instantiates a new Game.
     */
    public Game() {
        players = new Player[]{
            new Player(1),
            new Player(2)
        };
    }

    /**
     * Start.
     */
    public void start() {
        int i = 0;
        int j = 1;
        int size = players.length;
        Player player = null;

        while(players[0].getLives() > 0 && players[1].getLives() > 0) {
            players[i++ % size].turnToPlay(players[j++ % size]);
            player = (players[0].getLives() < players[1].getLives()) ?
                players[1] :
                players[0];
        }

        System.out.printf("Congrats Player %d, you won!",player.getId());
    }
}
