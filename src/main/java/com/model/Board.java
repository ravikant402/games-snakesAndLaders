package com.model;

import java.util.List;

public class Board {
    private final int size;
    private List<Player> players;

    public Board(int size, List<Player> players) {
        this.size = size;
        this.players = players;
    }

    public int getSize() {
        return size;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
