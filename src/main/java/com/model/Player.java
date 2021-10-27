package com.model;

import java.util.LinkedList;

public class Player {
    private String name;
    private int position;
    private LinkedList<Integer> snakeBitePositions;

    public Player(String name) {
        this.name = name;
        this.position = 0;
        snakeBitePositions = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public LinkedList<Integer> getSnakeBitePositions() {
        return snakeBitePositions;
    }

    public void addSnakeBitePosition (int bitePosition){
        snakeBitePositions.add(bitePosition);
    }

}
