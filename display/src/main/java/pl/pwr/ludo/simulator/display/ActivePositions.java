package pl.pwr.ludo.simulator.display;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import pl.pwr.ludo.simulator.logic.Pawn;

public class ActivePositions {
    private final List<DisplayPosition> positions = new ArrayList<>();
    private final int X_SEPARATOR = 2;
    private final int Y_SEPARATOR = 1;
    private static final int MIN_POSITION = 1;
    private static final int MAX_POSITION = 5;
    public ActivePositions() {
        this.generateSegment(new DisplayPosition(0,4), new DisplayPosition(10, 0));
        this.generateSegment(new DisplayPosition(12,0), new DisplayPosition(20, 5));
        this.generateSegment(new DisplayPosition(20,6), new DisplayPosition(10, 10));
        this.generateSegment(new DisplayPosition(8,10), new DisplayPosition(0, 5));
    }

    private void generateSegment(DisplayPosition player1, DisplayPosition player2) {
        int x = player1.x();
        int y = player1.y();
        positions.add(new DisplayPosition(x, y));

        List<DisplayPosition> positionsToAdd;
        if (x < player2.x() && y > player2.y()) {

            positionsToAdd =  generatePositions(x, MIN_POSITION, MAX_POSITION-1, 1,
                    y, 0, 0, 0);
            positions.addAll(positionsToAdd);

            positionsToAdd = generatePositions(x, MAX_POSITION-1, MAX_POSITION-1, 0,
                    y, -(MAX_POSITION-1), -MIN_POSITION, 1);
            Collections.reverse(positionsToAdd);
            positions.addAll(positionsToAdd);

            positions.add(new DisplayPosition(x + MAX_POSITION*X_SEPARATOR,
                    y - (MAX_POSITION-1)*Y_SEPARATOR));
        }
        if (x < player2.x() && y < player2.y()) {

            positionsToAdd = generatePositions(x, 0, 0, 0,
                    y, MIN_POSITION, MAX_POSITION-1, 1);
            positions.addAll(positionsToAdd);

            positionsToAdd = generatePositions(x, MIN_POSITION, MAX_POSITION-1, 1,
                    y, MAX_POSITION-1, MAX_POSITION-1, 0);
            positions.addAll(positionsToAdd);

            positions.add(new DisplayPosition(x + (MAX_POSITION-1)*X_SEPARATOR,
                    y + MAX_POSITION*Y_SEPARATOR));
        }
        if (x > player2.x() && y < player2.y()) {

            positionsToAdd = generatePositions(x, -(MAX_POSITION-1), -MIN_POSITION, 1,
                    y, 0, 0, 0);
            Collections.reverse(positionsToAdd);
            positions.addAll(positionsToAdd);

            positionsToAdd = generatePositions(x, -(MAX_POSITION-1), -(MAX_POSITION-1), 0,
                    y, MIN_POSITION, MAX_POSITION-1, 1);
            positions.addAll(positionsToAdd);

            positions.add(new DisplayPosition(x - MAX_POSITION*X_SEPARATOR,
                    y + (MAX_POSITION-1)*Y_SEPARATOR));
        }
        if (x > player2.x() && y > player2.y()) {

            positionsToAdd = generatePositions(x, 0, 0, 0,
                    y, -(MAX_POSITION-1), -MIN_POSITION, 1);
            Collections.reverse(positionsToAdd);
            positions.addAll(positionsToAdd);

            positionsToAdd = generatePositions(x, -(MAX_POSITION-1), -MIN_POSITION, 1,
                    y, -(MAX_POSITION-1), -(MAX_POSITION-1), 0);
            Collections.reverse(positionsToAdd);
            positions.addAll(positionsToAdd);

            positions.add(new DisplayPosition(x - (MAX_POSITION-1)*X_SEPARATOR,
                    y - MAX_POSITION*Y_SEPARATOR));
        }
    }

    private List<DisplayPosition> generatePositions(int x, int minX, int maxX, int xInterval,
                                      int y, int minY, int maxY, int yInterval) {
        List<DisplayPosition> displayPositions = new ArrayList<>();

        for (int i = minX, j = minY; i <= maxX && j <= maxY; i += xInterval, j += yInterval)
            displayPositions.add(new DisplayPosition(x + i*X_SEPARATOR, y + j*Y_SEPARATOR));

        return displayPositions;
    }

    public DisplayPosition get(int index) {
        return this.positions.get(index);
    }

    public DisplayPosition get(Pawn pawn) {
        return this.positions.get(pawn.getPosition());
    }
}