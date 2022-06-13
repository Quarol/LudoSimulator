package pl.pwr.ludoSimulator.logic;

public class PlayerInitializer {
    private static int counter = 0;

    public Player initialize() {
        int id = counter;
        PlayerInitializer.counter++;
        int startPosition = id*10;
        int endPosition = Math.floorMod(startPosition-1, 40);
        return new Player(id, startPosition, endPosition);
    }
}
