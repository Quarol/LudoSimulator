package pl.pwr.ludoSimulator.display;

import java.util.ArrayList;
import java.util.List;

public class StartPositions {
    private final List<DisplayPosition> positions = new ArrayList<>();
    public StartPositions () {
        positions.add(new DisplayPosition(0,4));
        positions.add(new DisplayPosition(12, 0));
        positions.add(new DisplayPosition(20,6));
        positions.add(new DisplayPosition(8,10));
    }
    public DisplayPosition get (int index) {
        return this.positions.get(index);
    }
}