package com.model;

import java.util.List;
import java.util.Map;

public class Board {
    private final int size;
    private List<Player> players;
    private Map<Integer, Integer> snakes;
    private Map<Integer, Integer> ladders;

    public Board(int size, List<Player> players, Map<Integer, Integer> snakes, Map<Integer, Integer> ladders) {
        this.size = size;
        this.players = players;
        this.snakes = snakes;
        this.ladders = ladders;
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

    public Map<Integer, Integer> getLadders() {
        return ladders;
    }
}
