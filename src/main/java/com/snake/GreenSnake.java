package com.snake;

public class GreenSnake extends Snake {

    private int bites;
    private final int startPoint;
    private final int endpoint;

    private int currBites;

    public GreenSnake(int startPoint, int endpoint) {
        this.startPoint = startPoint;
        this.endpoint = endpoint;
        this.bites = 0;
        this.currBites = 0;
    }

    @Override
    public boolean shouldBite(int head) {
        if (head == startPoint) {
            addBite();
        }
        if(bites == currBites) {
            currBites = 0;
            return true;
        }
        return false;
    }

    @Override
    public void addBite() {
        currBites++;
    }

    public int getStartPoint() {
        return startPoint;
    }

    public int getEndpoint() {
        return endpoint;
    }

    public void setBites(int bites) {
        this.bites = bites;
    }
}
