package pl.pwr.ludo.simulator.display;

import java.util.ArrayList;
import java.util.List;

import pl.pwr.ludo.simulator.logic.Board;
import pl.pwr.ludo.simulator.logic.Pawn;
import pl.pwr.ludo.simulator.logic.Player;
import pl.pwr.ludo.simulator.logic.PlayerPawns;

public class Display {
    private final List<List<Character>> displayTable = new ArrayList<>();
    private final Board board;
    private final BasePositions basePositions = new BasePositions();
    private final EndPositions endPositions = new EndPositions();
    private final ActivePositions activePositions = new ActivePositions();
    private final StartPositions[] startPositions = StartPositions.values();

    private void setDisplayTableField(DisplayPosition position, char value) {
        this.displayTable.get(position.x()).set(position.y(), value);
    }

    private void setDisplayTableField(DisplayPosition position, int value) {
        this.displayTable.get(position.x()).set(position.y(), Character.forDigit(value, 10));
    }

    public Display(Board board) {
        this.board = board;
    }

    private void renderNewDisplay() {
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
        setDisplayTableField(startPositions[0].get(), '>');
        setDisplayTableField(startPositions[1].get(), 'V');
        setDisplayTableField(startPositions[2].get(), '<');
        setDisplayTableField(startPositions[3].get(), '^');
        for (int i = 0; i < 16; i++) {
            setDisplayTableField(endPositions.get(i), 'X');
        }
    }

    private void renderDisplay() {
        this.renderNewDisplay();

        for (Player player : board.getPlayers()) {
            PlayerPawns playerPawns = player.getPawns();
            for (int i = 0; i < playerPawns.getBasePawns().size(); i++) {
                setDisplayTableField(basePositions.getPosition(player.getId() + 1, i), player.getId() + 1);
            }
            for (Pawn pawn : playerPawns.getEndPawns()) {
                setDisplayTableField(endPositions.getPosition(player, pawn), player.getId() + 1);
            }
            for (Pawn pawn : playerPawns.getActivePawns()) {
                setDisplayTableField(activePositions.get(pawn), player.getId() + 1);
            }
        }
    }

    public void display() {
        System.out.println(this);
    }

    public String toString() {
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
