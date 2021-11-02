package com.dice;

import java.util.Random;

public abstract class Dice {

    protected static final int maxDiceValue = 6;
    protected static final int minDiceValue = 1;
    Random random = new Random();

    public abstract int roll();
}
