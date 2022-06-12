package pl.pwr.ludoSimulator.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player  {
    private List<Pawn> basePawns = new ArrayList<>(Arrays.asList(new Pawn(), new Pawn(), new Pawn(), new Pawn()));
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

    public void setBasePawns(List<Pawn> basePawns) {
        this.basePawns = basePawns;
    }

    public List<Pawn> getActivePawns() {
        return activePawns;
    }

    private int id;
    private int startPosition;
    private final int endPosition;

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

    public int getId() {
        return id;
    }
    public Player(int id, int startPosition,int endPosition) {
        this.id = id;
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }
}