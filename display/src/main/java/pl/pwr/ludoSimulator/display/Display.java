package pl.pwr.ludoSimulator.display;

import java.util.ArrayList;
import java.util.List;
import pl.pwr.ludoSimulator.logic.Board;
import pl.pwr.ludoSimulator.logic.pawns.BasePawn;
import pl.pwr.ludoSimulator.logic.Player;
import pl.pwr.ludoSimulator.logic.pawns.EndPawn;
import pl.pwr.ludoSimulator.logic.pawns.ActivePawn;

public class Display {
    private final List<List<Character>> displayTable = new ArrayList<>();
    private final Board board;
    private final BasePositions basePositions = new BasePositions();
    private final EndPositions endPositions = new EndPositions();
    private final ActivePositions activePositions = new ActivePositions();
    private final StartPositions startPositions = new StartPositions();
    private void setDisplayTableField (DisplayPosition position, char value) {
        this.displayTable.get(position.getX()).set(position.getY(), value);
    }
    private void setDisplayTableField (DisplayPosition position, int value) {
        this.displayTable.get(position.getX()).set(position.getY(), Character.forDigit(value, 10));
    }
    public Display (Board board) {
        this.board = board;
        for (int i = 0; i < 22; i++) {
            this.displayTable.add(new ArrayList<>());
            for (int j = 0; j < 11; j++) {
                this.displayTable.get(i).add(' ');
                this.displayTable.get(i).set(j, ' ');
            }
        }
    }
    private void renderNewDisplay () {
        for (int i = 0; i < 22; i++) {
            this.displayTable.add(new ArrayList<>());
            for (int j = 0; j < 11; j++) {
                this.displayTable.get(i).add(' ');
                this.displayTable.get(i).set(j, ' ');
            }
        }
        for (int i = 0; i < 40; i++) {
            setDisplayTableField(activePositions.get(i), 'O');
        }
        setDisplayTableField(startPositions.get(0), '>');
        setDisplayTableField(startPositions.get(1), 'V');
        setDisplayTableField(startPositions.get(2), '<');
        setDisplayTableField(startPositions.get(3), '^');
        for (int i = 0; i < 16; i++) {
            setDisplayTableField(endPositions.get(i), 'X');
        }
    }
    private void renderDisplay () {
        this.renderNewDisplay();
        for (Player player : board.getPlayers()) {
            for (int i = 0; i < player.getBasePawns().size(); i++) {
                setDisplayTableField(basePositions.getPosition(player, i), player.getId()+1);
            }
            for (EndPawn pawn : player.getEndPawns()) {
                setDisplayTableField(endPositions.getPosition(player, pawn), player.getId()+1);
            }
            for (ActivePawn pawn : player.getActivePawns()) {
                setDisplayTableField(activePositions.get(pawn), player.getId()+1);
            }
        }
    }
    public void display () {
        System.out.println(this);
    }
    public String toString () {
        renderDisplay();
        StringBuilder str = new StringBuilder();
        str.append("\n");
        for (int y = 0; y < 11; y++) {
            for (int x = 0; x < 22; x++) {
                str.append(displayTable.get(x).get(y));
            }
            str.append("\n");
        }
        return str.toString();
    }
}
