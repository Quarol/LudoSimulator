package pl.pwr.ludoSimulator.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player  {
    private List<Pawn> basePawns = new ArrayList<>(Arrays.asList(new Pawn(), new Pawn(), new Pawn(), new Pawn()));
    private final List<Pawn> activePawns = new ArrayList<>();
    private final List<Pawn> endPawns = new ArrayList<>();

    private int id;
    private int startPosition;
    private final int endPosition;

    public int getStartPosition() {
        return startPosition;
    }

    public int getEndPosition() {
        return endPosition;
    }

    public int getId() {
        return id;
    }
    public Player(int id, int startPosition,int endPosition) {
        this.id = id;
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }
}