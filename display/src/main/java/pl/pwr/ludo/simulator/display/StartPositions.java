package pl.pwr.ludo.simulator.display;

public enum StartPositions {
    PLAYER1, PLAYER2, PLAYER3, PLAYER4;
    public DisplayPosition get() {
        return switch (this) {
            case PLAYER1 -> new DisplayPosition(0, 4);
            case PLAYER2 -> new DisplayPosition(12, 0);
            case PLAYER3 -> new DisplayPosition(20, 6);
            case PLAYER4 -> new DisplayPosition(8, 10);
        };
    }
}