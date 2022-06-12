package pl.pwr.ludoSimulator.display;

import java.util.ArrayList;
import java.util.List;
import pl.pwr.ludoSimulator.logic.Player;

public class BasePositions {
    private final List<DisplayPosition> positions = new ArrayList<>();
    public void generatePositions (int playerId) {
        switch (playerId) {
            case 1 -> {
                positions.add(new DisplayPosition(0, 0));
                positions.add(new DisplayPosition(1, 0));
                positions.add(new DisplayPosition(0, 1));
                positions.add(new DisplayPosition(1, 1));
            }
            case 2 -> {
                positions.add(new DisplayPosition(19, 0));
                positions.add(new DisplayPosition(20, 0));
                positions.add(new DisplayPosition(19, 1));
                positions.add(new DisplayPosition(20, 1));
            }
            case 3 -> {
                positions.add(new DisplayPosition(19, 9));
                positions.add(new DisplayPosition(20, 9));
                positions.add(new DisplayPosition(19, 10));
                positions.add(new DisplayPosition(20, 10));
            }
            case 4 -> {
                positions.add(new DisplayPosition(0, 9));
                positions.add(new DisplayPosition(1, 9));
                positions.add(new DisplayPosition(0, 10));
                positions.add(new DisplayPosition(1, 10));
            }
        }
    }
    public BasePositions () {
        for (int i = 1; i <= 4; i++) {
            this.generatePositions(i);
        }
    }
    public DisplayPosition getPosition (int playerId, int pawnPosition) {
        return positions.get(playerId*4+pawnPosition);
    }
    public DisplayPosition getPosition (Player player, int pawnPosition) {
        int playerId = player.getId();
        return positions.get(playerId*4+pawnPosition);
    }
}