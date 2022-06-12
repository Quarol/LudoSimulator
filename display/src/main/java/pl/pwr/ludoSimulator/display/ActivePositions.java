package pl.pwr.ludoSimulator.display;

import pl.pwr.ludoSimulator.logic.Pawn;

import java.util.ArrayList;
import java.util.List;

public class ActivePositions {
    private final List<DisplayPosition> positions = new ArrayList<>();
    public void generatePosition (int position) {
        switch (position) {
            case 1:
                positions.add(new DisplayPosition(0,4));
            case 2:
                positions.add(new DisplayPosition(2,4));
            case 3:
                positions.add(new DisplayPosition(4,4));
            case 4:
                positions.add(new DisplayPosition(6,4));
            case 5:
                positions.add(new DisplayPosition(8,4));
            case 6:
                positions.add(new DisplayPosition(8,3));
            case 7:
                positions.add(new DisplayPosition(8,2));
            case 8:
                positions.add(new DisplayPosition(8,1));
            case 9:
                positions.add(new DisplayPosition(8,0));
            case 10:
                positions.add(new DisplayPosition(10,0));
            case 11:
                positions.add(new DisplayPosition(12,0));
            case 12:
                positions.add(new DisplayPosition(12,1));
            case 13:
                positions.add(new DisplayPosition(12,2));
            case 14:
                positions.add(new DisplayPosition(12,3));
            case 15:
                positions.add(new DisplayPosition(12,4));
            case 16:
                positions.add(new DisplayPosition(14,4));
            case 17:
                positions.add(new DisplayPosition(16,4));
            case 18:
                positions.add(new DisplayPosition(18,4));
            case 19:
                positions.add(new DisplayPosition(20,4));
            case 20:
                positions.add(new DisplayPosition(20,5));
            case 21:
                positions.add(new DisplayPosition(20,6));
            case 22:
                positions.add(new DisplayPosition(18,6));
            case 23:
                positions.add(new DisplayPosition(16,6));
            case 24:
                positions.add(new DisplayPosition(14,6));
            case 25:
                positions.add(new DisplayPosition(12,6));
            case 26:
                positions.add(new DisplayPosition(12,7));
            case 27:
                positions.add(new DisplayPosition(12,8));
            case 28:
                positions.add(new DisplayPosition(12,9));
            case 29:
                positions.add(new DisplayPosition(12,10));
            case 30:
                positions.add(new DisplayPosition(10,10));
            case 31:
                positions.add(new DisplayPosition(8,10));
            case 32:
                positions.add(new DisplayPosition(8,9));
            case 33:
                positions.add(new DisplayPosition(8,8));
            case 34:
                positions.add(new DisplayPosition(8,7));
            case 35:
                positions.add(new DisplayPosition(8,6));
            case 36:
                positions.add(new DisplayPosition(6,6));
            case 37:
                positions.add(new DisplayPosition(4,6));
            case 38:
                positions.add(new DisplayPosition(2,6));
            case 39:
                positions.add(new DisplayPosition(0,6));
            case 40:
                positions.add(new DisplayPosition(0,5));
        }
    }
    public ActivePositions () {
        for (int i = 1; i <= 40; i++) {
            this.generatePosition(i);
        }
    }
    public DisplayPosition get (int index) {
        return this.positions.get(index);
    }
    public DisplayPosition get (Pawn pawn) {
        return this.positions.get(pawn.getPosition());
    }
}