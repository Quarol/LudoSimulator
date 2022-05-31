package pl.pwr.ludoSimulator.display;

import java.util.ArrayList;
import java.util.List;
import pl.pwr.ludoSimulator.logic.Player;
import pl.pwr.ludoSimulator.logic.pawns.EndPawn;

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
    public List<DisplayPosition> getPositions (int playerId) {
        return List.of(this.positions.get((playerId)*4), this.positions.get((playerId)*4+1), this.positions.get((playerId)*4+2), this.positions.get((playerId)*4+3));
    }
    public DisplayPosition get (int index) {
        return this.positions.get(index);
    }
    public DisplayPosition getPosition (int playerId, int pawnPosition) {
        return positions.get(playerId*4+pawnPosition);
    }
    public DisplayPosition getPosition (Player player, int pawnPosition) {
        int playerId = player.getId();
        return positions.get(playerId*4+pawnPosition);
    }
    public DisplayPosition getPosition (int playerId, EndPawn pawn) {
        return positions.get(playerId*4+pawn.getPosition());
    }
    public DisplayPosition getPosition (Player player, EndPawn pawn) {
        int playerId = player.getId();
        return positions.get(playerId*4+ pawn.getPosition());
    }
}