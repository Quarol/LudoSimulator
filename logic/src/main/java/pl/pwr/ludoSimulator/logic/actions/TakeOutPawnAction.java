package pl.pwr.ludoSimulator.logic.actions;

import pl.pwr.ludoSimulator.logic.Board;
import pl.pwr.ludoSimulator.logic.Pawn;
import pl.pwr.ludoSimulator.logic.Player;

import java.util.ArrayList;
import java.util.List;

public class TakeOutPawnAction implements Action {
    private Board board;
    private Player player;
    private boolean possible;
    @Override
    public boolean isPossible(Board board, Player player, int roll) {
        if (roll != 6) {
            return false;
        }
        this.board = board;
        this.player = player;
        this.possible = this.player.getBasePawns().size() != 0;

        for (Pawn pawn : this.player.getActivePawns()) {
            if (pawn.getPosition() == this.player.getStartPosition()) {
                return this.possible = false;
            }
        }
        return this.possible;
    }
    public List<Pawn> getPawns () {
        List<Pawn> list = new ArrayList<>();
        list.add(new Pawn(player.getStartPosition()));
        return list;
    }
    @Override
    public Board execute(Pawn pawn) {
        if (possible) {
            this.player.removeBasePawn();
            this.player.setBasePawns(this.player.getBasePawns());
            this.player.addActivePawn(pawn);
        }
        return this.board;
    }
}
