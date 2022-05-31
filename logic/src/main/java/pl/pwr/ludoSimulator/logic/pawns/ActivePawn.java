package pl.pwr.ludoSimulator.logic.pawns;
public class ActivePawn implements Pawn {
    private int position = 0;
    public ActivePawn (int position) {
        this.position = position;
    }
    public int getPosition () {
        return this.position;
    }
    public void setPosition (int position) {
        this.position = position;
    }
}
