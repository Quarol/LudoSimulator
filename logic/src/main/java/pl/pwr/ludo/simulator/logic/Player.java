package pl.pwr.ludo.simulator.logic;

public class Player {
    private final PlayerPawns pawns = new PlayerPawns();
    private final int id;
    private final int startPosition;
    private final int endPosition;

    public Player(int id, int startPosition, int endPosition) {
        this.id = id;
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }

    public int getId() {
        return id;
    }

    public int getStartPosition() {
        return startPosition;
    }

    public int getEndPosition() {
        return endPosition;
    }
    public PlayerPawns getPawns () {
        return pawns;
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Player player = (Player) o;
        return id == player.id;
    }

}