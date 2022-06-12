package pl.pwr.ludoSimulator.display;

import java.util.ArrayList;
import java.util.List;

import pl.pwr.ludoSimulator.logic.Pawn;
import pl.pwr.ludoSimulator.logic.Player;

public class EndPositions {
    private final List<DisplayPosition> positions = new ArrayList<>();
    public EndPositions () {
        positions.add(new DisplayPosition(2,5));
        positions.add(new DisplayPosition(4, 5));
        positions.add(new DisplayPosition(6, 5));
        positions.add(new DisplayPosition(8, 5));
        positions.add(new DisplayPosition(10,1));
        positions.add(new DisplayPosition(10, 2));
        positions.add(new DisplayPosition(10, 3));
        positions.add(new DisplayPosition(10, 4));
        positions.add(new DisplayPosition(18,5));
        positions.add(new DisplayPosition(16, 5));
        positions.add(new DisplayPosition(14, 5));
        positions.add(new DisplayPosition(12, 5));
        positions.add(new DisplayPosition(10,9));
        positions.add(new DisplayPosition(10, 8));
        positions.add(new DisplayPosition(10, 7));
        positions.add(new DisplayPosition(10, 6));
    }
    public DisplayPosition get (int index) {
        return this.positions.get(index);
    }
    public DisplayPosition getPosition (Player player, Pawn pawn) {
        int playerId = player.getId();
        return positions.get(playerId*4+ pawn.getPosition());
    }
}