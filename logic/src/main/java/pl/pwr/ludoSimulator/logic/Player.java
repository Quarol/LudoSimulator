package pl.pwr.ludoSimulator.logic;

public class Player  {
    private final int id;
    private final int startPosition;
    private final int endPosition;

    public int getStartPosition() {
        return startPosition;
    }

    public int getEndPosition() {
        return endPosition;
    }

    public int getId() {
        return id;
    }
    public Player(int id, int startPosition, int endPosition) {
        this.id = id;
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }
}