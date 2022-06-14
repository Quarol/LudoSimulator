package pl.pwr.ludoSimulator.display;

import java.util.ArrayList;
import java.util.List;

import pl.pwr.ludoSimulator.logic.Pawn;
import pl.pwr.ludoSimulator.logic.Player;

public class EndPositions {
    private final List<DisplayPosition> positions = new ArrayList<>();
    public EndPositions () {

        int x = 2;
        int y = 5;
        for (int i = x; i <= 8; i += 2) {
            positions.add(new DisplayPosition(i, y));
        }

        x = 10;
        y = 1;
        for (int j = y; j <= 4; ++j){
            positions.add(new DisplayPosition(x, j));
        }

        x = 18;
        y = 5;
        for (int i = x; i >= 12; i -= 2) {
            positions.add(new DisplayPosition(i, y));
        }

        x = 10;
        y = 9;
        for (int j = y; j >= 6; --j){
            positions.add(new DisplayPosition(x, j));
        }
    }
    public DisplayPosition get (int index) {
        return this.positions.get(index);
    }
    public DisplayPosition getPosition (Player player, Pawn pawn) {
        int playerId = player.getId();
        return positions.get(playerId*4+ pawn.getPosition());
    }
}