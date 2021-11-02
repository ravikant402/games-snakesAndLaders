package com.model;

import java.util.Map;

public class Board {
    private final int size;
    private Player player;
    private Map<Integer, Integer> snakes;
    private Map<Integer, Integer> ladders;

    public Board(int size, Player player, Map<Integer, Integer> snakes, Map<Integer, Integer> ladders) {
        this.size = size;
        this.player = player;
        this.snakes = snakes;
        this.ladders = ladders;
    }

    public int getSize() {
        return size;
    }

    public Player getPlayer() {
        return player;
    }

    public Map<Integer, Integer> getSnakes() {
        return snakes;
    }

    public Map<Integer, Integer> getLadders() {
        return ladders;
    }
}
