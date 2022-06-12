package pl.pwr.ludoSimulator.display;

import java.util.ArrayList;
import java.util.List;
import pl.pwr.ludoSimulator.logic.Player;

public class BasePositions {
    private final List<DisplayPosition> positions = new ArrayList<>();
    public DisplayPosition getPosition (int playerId, int pawnPosition) {
        int x = -1;
        int y = -1;
        List<DisplayPosition> positionList = new ArrayList<>();
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
        switch (pawnPosition) {
            case 0 -> {
                return new DisplayPosition(x, y);
            }
            case 1 -> {
                return new DisplayPosition(x+1, y);
            }
            case 2 -> {
                return new DisplayPosition(x, y+1);
            }
            case 3 -> {
                return new DisplayPosition(x+1, y+1);
            }
        }
        return null;
    }
}