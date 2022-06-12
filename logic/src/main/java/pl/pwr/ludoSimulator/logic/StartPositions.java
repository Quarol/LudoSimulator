package pl.pwr.ludoSimulator.logic;

public enum StartPositions {
    PLAYER1, PLAYER2, PLAYER3, PLAYER4;
    public int getStartPosition() {
        switch (this) {
            case PLAYER1:
                return 0;
            case PLAYER2:
                return 10;
            case PLAYER3:
                return 20;
            case PLAYER4:
                return 30;
        }
        return -1;
    }
}
