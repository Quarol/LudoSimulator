package pl.pwr.ludoSimulator.logic;

public class Player  {
    private int id;
    private int startPosition;
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