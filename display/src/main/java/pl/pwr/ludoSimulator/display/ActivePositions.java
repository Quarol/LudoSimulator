package pl.pwr.ludoSimulator.display;

import pl.pwr.ludoSimulator.logic.Pawn;

import java.util.ArrayList;
import java.util.List;

public class ActivePositions {
    private final List<DisplayPosition> positions = new ArrayList<>();
    private final int X_SEPARATOR = 2;
    private final int Y_SEPARATOR = 1;
    private static final int MIN_POSITION = 1;
    private static final int MAX_POSITION = 5;
    public ActivePositions() {
        this.generatePositions(new DisplayPosition(0,4), new DisplayPosition(10, 0));
        this.generatePositions(new DisplayPosition(12,0), new DisplayPosition(20, 5));
        this.generatePositions(new DisplayPosition(20,6), new DisplayPosition(10, 10));
        this.generatePositions(new DisplayPosition(8,10), new DisplayPosition(0, 5));
    }

    private void generatePositions(DisplayPosition player1, DisplayPosition player2) {
        int x = player1.x();
        int y = player1.y();
        positions.add(new DisplayPosition(x, y));
        if (x < player2.x() && y > player2.y()) {
            /*positions.add(new DisplayPosition(x+1*X_SEPARATOR, y));
            positions.add(new DisplayPosition(x+2*X_SEPARATOR, y));
            positions.add(new DisplayPosition(x+3*X_SEPARATOR, y));
            positions.add(new DisplayPosition(x+4*X_SEPARATOR, y));*/


            loop(x, MIN_POSITION, MAX_POSITION-1, 1, y, 0, 0, 0);
            //positions.addAll(loop(x, MIN_POSITION, MAX_POSITION, 1, 0, 0, 0, 0));

            positions.add(new DisplayPosition(x+4*X_SEPARATOR, y-Y_SEPARATOR));
            positions.add(new DisplayPosition(x+4*X_SEPARATOR, y-2*Y_SEPARATOR));
            positions.add(new DisplayPosition(x+4*X_SEPARATOR, y-3*Y_SEPARATOR));
            positions.add(new DisplayPosition(x+4*X_SEPARATOR, y-4*Y_SEPARATOR));

            positions.add(new DisplayPosition(x+5*X_SEPARATOR, y-4*Y_SEPARATOR));
        }
        if (x < player2.x() && y < player2.y()) {
            positions.add(new DisplayPosition(x, y+1*Y_SEPARATOR));
            positions.add(new DisplayPosition(x, y+2*Y_SEPARATOR));
            positions.add(new DisplayPosition(x, y+3*Y_SEPARATOR));
            positions.add(new DisplayPosition(x, y+4*Y_SEPARATOR));

            positions.add(new DisplayPosition(x+1*X_SEPARATOR, y+4*Y_SEPARATOR));
            positions.add(new DisplayPosition(x+2*X_SEPARATOR, y+4*Y_SEPARATOR));
            positions.add(new DisplayPosition(x+3*X_SEPARATOR, y+4*Y_SEPARATOR));
            positions.add(new DisplayPosition(x+4*X_SEPARATOR, y+4*Y_SEPARATOR));

            positions.add(new DisplayPosition(x+4*X_SEPARATOR, y+5*Y_SEPARATOR));
        }
        if (x > player2.x() && y < player2.y()) {
            positions.add(new DisplayPosition(x-1*X_SEPARATOR, y));
            positions.add(new DisplayPosition(x-2*X_SEPARATOR, y));
            positions.add(new DisplayPosition(x-3*X_SEPARATOR, y));
            positions.add(new DisplayPosition(x-4*X_SEPARATOR, y));

            positions.add(new DisplayPosition(x-4*X_SEPARATOR, y+1*Y_SEPARATOR));
            positions.add(new DisplayPosition(x-4*X_SEPARATOR, y+2*Y_SEPARATOR));
            positions.add(new DisplayPosition(x-4*X_SEPARATOR, y+3*Y_SEPARATOR));
            positions.add(new DisplayPosition(x-4*X_SEPARATOR, y+4*Y_SEPARATOR));

            positions.add(new DisplayPosition(x-5*X_SEPARATOR, y+4*Y_SEPARATOR));
        }
        if (x > player2.x() && y > player2.y()) {
            positions.add(new DisplayPosition(x, y-1*Y_SEPARATOR));
            positions.add(new DisplayPosition(x, y-2*Y_SEPARATOR));
            positions.add(new DisplayPosition(x, y-3*Y_SEPARATOR));
            positions.add(new DisplayPosition(x, y-4*Y_SEPARATOR));

            positions.add(new DisplayPosition(x-1*X_SEPARATOR, y-4*Y_SEPARATOR));
            positions.add(new DisplayPosition(x-2*X_SEPARATOR, y-4*Y_SEPARATOR));
            positions.add(new DisplayPosition(x-3*X_SEPARATOR, y-4*Y_SEPARATOR));
            positions.add(new DisplayPosition(x-4*X_SEPARATOR, y-4*Y_SEPARATOR));

            positions.add(new DisplayPosition(x-4*X_SEPARATOR, y-5*Y_SEPARATOR));
        }
    }

    private List<DisplayPosition> loop(int x, int minX, int maxX, int xInterval,
                                      int y, int minY, int maxY, int yInterval) {
        List<DisplayPosition> displayPositions = new ArrayList<>();

        for (int i = minX, j = minY; i <= maxX || j <= maxY; i += xInterval, j += yInterval)
            positions.add(new DisplayPosition(x + i*X_SEPARATOR, y + j*Y_SEPARATOR));

        return displayPositions;
    }

    public DisplayPosition get(int index) {
        return this.positions.get(index);
    }

    public DisplayPosition get(Pawn pawn) {
        return this.positions.get(pawn.getPosition());
    }
}