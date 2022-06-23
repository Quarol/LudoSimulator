package pl.pwr.ludo.simulator.display;

import java.util.ArrayList;
import java.util.List;

import pl.pwr.ludo.simulator.logic.Pawn;
import pl.pwr.ludo.simulator.logic.Player;

public class EndPositions {
    private final List<DisplayPosition> positions = new ArrayList<>();
    private static final int X_DIFFERENCE = 8;
    private static final int Y_DIFFERENCE = 4;
    private static final int MIN_X = 2;
    private static final int MID_X = MIN_X + X_DIFFERENCE;
    private static final int MAX_X = MIN_X + X_DIFFERENCE * 2;
    private static final int MIN_Y = 1;
    private static final int MID_Y = MIN_Y + Y_DIFFERENCE;
    private static final int MAX_Y = MIN_Y + Y_DIFFERENCE * 2;

    public EndPositions() {

        int x = MIN_X;
        int y = MID_Y;
        for (int i = x; i <= 8; i += 2) {
            positions.add(new DisplayPosition(i, y));
        }

        x = MID_X;
        y = MIN_Y;
        for (int j = y; j <= 4; ++j) {
            positions.add(new DisplayPosition(x, j));
        }

        x = MAX_X;
        y = MID_Y;
        for (int i = x; i >= 12; i -= 2) {
            positions.add(new DisplayPosition(i, y));
        }

        x = MID_X;
        y = MAX_Y;
        for (int j = y; j >= 6; --j) {
            positions.add(new DisplayPosition(x, j));
        }
    }

    public DisplayPosition get(int index) {
        return this.positions.get(index);
    }

    public DisplayPosition getPosition(Player player, Pawn pawn) {
        int playerId = player.id();
        return positions.get(playerId * 4 + pawn.getPosition());
    }
}