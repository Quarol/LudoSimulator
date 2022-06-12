package pl.pwr.ludoSimulator.display;

import java.util.ArrayList;
import java.util.List;
import pl.pwr.ludoSimulator.logic.Player;

public class BasePositions {
    private final List<DisplayPosition> positions = new ArrayList<>();
    public void generatePositions (int playerId) {
        int x = -1;
        int y = -1;
        switch (playerId) {
            case 1 -> {
                x = 0;
                y = 0;
            }
            case 2 -> {
                x = 19;
                y = 0;
            }
            case 3 -> {
                x = 19;
                y = 9;
            }
            case 4 -> {
                x = 0;
                y = 9;
            }
        }
        if (x != -1 && y != -1) {
            positions.add(new DisplayPosition(x, y));
            positions.add(new DisplayPosition(x + 1, y));
            positions.add(new DisplayPosition(x, y + 1));
            positions.add(new DisplayPosition(x + 1, y + 1));
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