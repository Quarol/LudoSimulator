package pl.pwr.ludoSimulator.logic;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final List<Player> players;
    public int getNumberOfPlayers() { return players.size(); }
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
    public Board (List<Player> players) {
        this.players =  players;
    }
}