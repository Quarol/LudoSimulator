package pl.pwr.ludoSimulator.display;

public class DisplayPosition {
    private final int x;
    private final int y;
    public DisplayPosition (int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX () {
        return x;
    }
    public int getY () {
        return y;
    }
}