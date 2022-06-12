package pl.pwr.ludoSimulator.logic;

import pl.pwr.ludoSimulator.logic.pawns.ActivePawn;
import pl.pwr.ludoSimulator.logic.pawns.BasePawn;
import pl.pwr.ludoSimulator.logic.pawns.EndPawn;
import pl.pwr.ludoSimulator.logic.StartPositions;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player implements Cloneable {
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return new Object();
        }
    }

    private List<BasePawn> basePawns = new ArrayList<>();
    private final List<ActivePawn> activePawns = new ArrayList<>();
    private final List<EndPawn> endPawns = new ArrayList<>();

    public boolean hasEnded() {
        return endPawns.size() == 4;
    }

    public List<EndPawn> getEndPawns() {
        return endPawns;
    }

    public List<BasePawn> getBasePawns() {
        return basePawns;
    }

    public void setBasePawns(List<BasePawn> basePawns) {
        this.basePawns = basePawns;
    }

    public ActivePawn getActivePawn(int index) {
        return activePawns.get(index);
    }

    public List<ActivePawn> getActivePawns() {
        return activePawns;
    }

    private static int counter = 0;
    private final int id;
    private int startPosition;

    public int getStartPosition() {
        return startPosition;
    }

    public int getEndPosition() {
        return endPosition;
    }

    public void addActivePawn(ActivePawn pawn) {
        this.activePawns.add(pawn);
    }

    public void addEndPawn(EndPawn pawn) {
        this.endPawns.add(pawn);
    }

    public void addBasePawn(BasePawn pawn) {
        this.basePawns.add(pawn);
    }

    public void removeActivePawn(ActivePawn pawn) {
        this.activePawns.remove(pawn);
    }

    public void removeBasePawn() {
        this.basePawns.remove(basePawns.get(0));
    }

    private int endPosition;

    public int getId() {
        return id;
    }

    public Player() {
        this.id = counter;
        Player.counter++;
        this.startPosition = StartPositions.values()[this.id].getStartPosition();
        this.endPosition = Math.floorMod(startPosition-1, 40);
        this.basePawns.add(new BasePawn());
        this.basePawns.add(new BasePawn());
        this.basePawns.add(new BasePawn());
        this.basePawns.add(new BasePawn());
    }
}