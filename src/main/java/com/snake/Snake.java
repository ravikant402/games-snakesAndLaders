package com.snake;

public abstract class Snake {

    public abstract boolean shouldBite(int head);

    public abstract void addBite();

    public abstract int getStartPoint();

    public abstract int getEndpoint();

}
