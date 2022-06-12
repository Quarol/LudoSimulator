package pl.pwr.ludoSimulator.logic.actions;

import pl.pwr.ludoSimulator.logic.*;

import java.util.ArrayList;
import java.util.List;
public class KillPawnAction implements Action {
    @Override
    public boolean isPossible(Board board, Player player, int roll) {
        return getPawns(board, player, roll).size() != 0;
    }

    private List<Pawn> getPawns(Board board, Player player, int roll) {
        List<Integer> usedPositions = new ArrayList<>();
        List<Integer> otherPlayersUsedPositions = new ArrayList<>();
        List<Pawn> activePawnsWhichCanKill = new ArrayList<>();
        for (Player p : board.getPlayers()) {
            if (p.getId() != player.getId()) {
                for (Pawn pawn : p.getActivePawns()) {
                    otherPlayersUsedPositions.add(pawn.getPosition());
                }
            }
        }
        for (Pawn pawn : player.getActivePawns()) {
            if (!usedPositions.contains((pawn.getPosition() + roll) % 40) && otherPlayersUsedPositions.contains((pawn.getPosition() + roll) % 40)) {
                if (pawn.getPosition() + roll < player.getEndPosition()) {
                    activePawnsWhichCanKill.add(pawn);
                } else if (pawn.getPosition() > player.getEndPosition()) {
                    activePawnsWhichCanKill.add(pawn);
                }
            }
        }
        return activePawnsWhichCanKill;
    }

    @Override
    public Board execute(Board board, Player player, int roll) {
        int endPosition = player.getEndPosition();
        List<Pawn> pawns = getPawns(board, player, roll);
        if (pawns.size() != 0 ) {
            Pawn pawn = pawns.get(0);
            if (pawn.getPosition()+roll < endPosition || pawn.getPosition() > endPosition) {
                int position = (pawn.getPosition()+roll)%40;
                for (Player currentPlayer : board.getActivePlayers()) {
                    for (Pawn p : currentPlayer.getActivePawns()) {
                        if (p.getPosition() == position) {
                            currentPlayer.removeActivePawn(p);
                            currentPlayer.addBasePawn(new Pawn());
                            break;
                        }
                    }
                }
                pawn.setPosition((pawn.getPosition()+roll)%40);
            }
        }
        return board;
    }
}
