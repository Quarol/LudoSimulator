package pl.pwr.ludo.simulator.logic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Board {
    private final List<Player> players;

    public List<Player> getPlayers() {
        return players;
    }

    public Player getPlayer(int index) {
        return players.get(index);
    }

    private final Map<Player, PlayerPawns> playersMap = new HashMap<>();

    public PlayerPawns getPlayerPawns(Player player) {
        return this.playersMap.get(player);
    }

    public List<Player> getActivePlayers() {
        return players.stream()
                .filter(this::doesntHaveAllPawnsInHome)
                .collect(Collectors.toList());
    }

    private boolean doesntHaveAllPawnsInHome(Player player) {
        return getPlayerPawns(player).getEndPawns().size() != 4;
    }
    public boolean hasAnyActivePlayer() {
        return getActivePlayers().size() > 1;
    }
    public Board(List<Player> players) {
        this.players = players;
        for (Player player : players) {
            playersMap.put(player, new PlayerPawns());
        }
    }
}