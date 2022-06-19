package pl.pwr.ludoSimulator.logic;

public class PlayerInitializer {

    public Player initialize(int id) {
        int startPosition = id*10;
        int endPosition = Math.floorMod(startPosition-1, 40);
        return new Player(id, startPosition, endPosition);
    }
}
