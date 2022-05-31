package pl.pwr.ludoSimulator.logic;

import pl.pwr.ludoSimulator.logic.pawns.ActivePawn;
import pl.pwr.ludoSimulator.logic.pawns.BasePawn;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final int numberOfPlayers;
    private final List<Player> players = new ArrayList<>();
    public int getNumberOfPlayers() { return numberOfPlayers; }
    public List<Player> getPlayers () {
        return players;
    }
    public Player getPlayer (int index) {
        return players.get(index);
    }

    public List<Player> getActivePlayers() {
        List<Player> list = new ArrayList<>();
        for (Player player : players) {
            if (!player.hasEnded()) {
                list.add(player);
            }
        }
        return list;
    }
    public Board (int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
        for (int i = 0; i < numberOfPlayers; ++i)
            players.add(new Player());
    }
}