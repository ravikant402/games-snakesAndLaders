package com.snake;

public class NormalSnake extends Snake{

    private final int startPoint;
    private final int endpoint;

    public NormalSnake(int startPoint, int endpoint) {
        this.startPoint = startPoint;
        this.endpoint = endpoint;
    }

    @Override
    public boolean shouldBite(int head) {
        if(head == startPoint) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void addBite() {
        //not bites
    }

    public int getStartPoint() {
        return startPoint;
    }

    public int getEndpoint() {
        return endpoint;
    }
}
