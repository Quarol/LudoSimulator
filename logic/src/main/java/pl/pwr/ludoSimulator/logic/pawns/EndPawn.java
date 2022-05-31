package pl.pwr.ludoSimulator.logic.pawns;

public class EndPawn implements Pawn{
    private int position;
    public EndPawn (int position) {
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
