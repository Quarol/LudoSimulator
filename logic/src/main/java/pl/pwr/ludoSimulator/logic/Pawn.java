package pl.pwr.ludoSimulator.logic;

public class Pawn {
    private int position = 0;
    public Pawn() {}
    public Pawn (int position) {
        this.position = position;
    }
    public int getPosition() {
        return position;
    }
    public void setPosition(int position) {
        this.position = position;
    }
    public void move (int steps) {
        this.position += steps;
    }
}
