package pl.pwr.ludoSimulator.logic;

public class PlayerInitializer {
    private static int counter = 0;

    public Player initialize() {

        int id = counter;
        this.counter++;
        int startPosition = StartPositions.values()[id].getStartPosition();
        int endPosition = Math.floorMod(startPosition-1, 40);
        Player player = new Player(id, startPosition, endPosition);

        return player;
    }
}
