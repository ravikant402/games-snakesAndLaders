package com.model;

import java.util.List;
import java.util.Map;

public class Board {
    private final int size;
    private List<Player> players;
    private Map<Integer, Integer> snakes;

    public Board(int size, List<Player> players, Map<Integer, Integer> snakes) {
        this.size = size;
        this.players = players;
        this.snakes = snakes;
    }

    public int getSize() {
        return size;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Map<Integer, Integer> getSnakes() {
        return snakes;
    }

    public void setSnakes(Map<Integer, Integer> snakes) {
        this.snakes = snakes;
    }
}
