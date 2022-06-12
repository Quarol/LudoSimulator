package pl.pwr.ludoSimulator.display;

public enum StartPositions {
    PLAYER1, PLAYER2, PLAYER3, PLAYER4;
    public DisplayPosition get() {
        switch (this) {
            case PLAYER1:
                return new DisplayPosition(0,4);
            case PLAYER2:
                return new DisplayPosition(12, 0);
            case PLAYER3:
                return new DisplayPosition(20,6);
            case PLAYER4:
                return new DisplayPosition(8,10);
        }
        return new DisplayPosition(-1, -1);
    }
}