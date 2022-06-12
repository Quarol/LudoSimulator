package pl.pwr.ludoSimulator.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player  {
    private final List<Pawn> basePawns = new ArrayList<>(Arrays.asList(new Pawn(), new Pawn(), new Pawn(), new Pawn()));
    private final List<Pawn> activePawns = new ArrayList<>();
    private final List<Pawn> endPawns = new ArrayList<>();

    public boolean hasEnded() {
        return endPawns.size() == 4;
    }

    public List<Pawn> getEndPawns() {
        return endPawns;
    }

    public List<Pawn> getBasePawns() {
        return basePawns;
    }

    public List<Pawn> getActivePawns() {
        return activePawns;
    }

    private static int counter = 0;
    private final int id;
    private final int startPosition;

    public int getStartPosition() {
        return startPosition;
    }

    public int getEndPosition() {
        return endPosition;
    }

    public void addActivePawn(Pawn pawn) {
        this.activePawns.add(pawn);
    }

    public void addEndPawn(Pawn pawn) {
        this.endPawns.add(pawn);
    }

    public void addBasePawn(Pawn pawn) {
        this.basePawns.add(pawn);
    }

    public void removeActivePawn(Pawn pawn) {
        this.activePawns.remove(pawn);
    }

    public void removeBasePawn() {
        this.basePawns.remove(basePawns.get(0));
    }

    private final int endPosition;

    public int getId() {
        return id;
    }

    public Player() {
        this.id = counter;
        Player.counter++;
        this.startPosition = StartPositions.values()[this.id].getStartPosition();
        this.endPosition = Math.floorMod(startPosition-1, 40);
    }
}