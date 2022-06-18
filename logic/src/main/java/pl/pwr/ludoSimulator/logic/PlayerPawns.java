package pl.pwr.ludoSimulator.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayerPawns {
    private final List<Pawn> basePawns = new ArrayList<>(Arrays.asList(new Pawn(), new Pawn(), new Pawn(), new Pawn()));
    private final List<Pawn> activePawns = new ArrayList<>();
    private final List<Pawn> endPawns = new ArrayList<>();
    public List<Pawn> getEndPawns() {
        return endPawns;
    }

    public List<Pawn> getBasePawns() {
        return basePawns;
    }
    public List<Pawn> getActivePawns() {
        return activePawns;
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
}
