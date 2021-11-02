package com.model;

import com.snake.Snake;

import java.util.List;
import java.util.Map;

public class Board {
    private final int size;
    private Player player;
    private List<Snake> snakes;
    private Map<Integer, Integer> ladders;

    public Board(int size, Player player, List<Snake> snakes, Map<Integer, Integer> ladders) {
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

    public List<Snake> getSnakes() {
        return snakes;
    }

    public Map<Integer, Integer> getLadders() {
        return ladders;
    }
}
