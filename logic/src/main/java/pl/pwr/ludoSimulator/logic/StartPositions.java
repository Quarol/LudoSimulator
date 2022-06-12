package pl.pwr.ludoSimulator.logic;

public enum StartPositions {
    PLAYER1, PLAYER2, PLAYER3, PLAYER4;
    public int getStartPosition() {
        return switch (this) {
            case PLAYER1 -> 0;
            case PLAYER2 -> 10;
            case PLAYER3 -> 20;
            case PLAYER4 -> 30;
        };
    }
}
