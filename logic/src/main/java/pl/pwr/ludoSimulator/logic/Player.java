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

    private int id;
    private int startPosition;

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

    private int endPosition;

    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setStartPosition(int startPosition) {
        this.startPosition = startPosition;
    }

    public void setEndPosition(int endPosition) {
        this.endPosition = endPosition;
    }

    public Player() {
    }
}