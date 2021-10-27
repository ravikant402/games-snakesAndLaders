package com.model.dice;

import java.util.Random;

public abstract class Dice {

    int maxDiceValue;
    int minDiceValue;
    Random random = new Random();

    public Dice(int minDiceValue, int maxDiceValue) {
        this.maxDiceValue = maxDiceValue;
        this.minDiceValue = minDiceValue;
    }

    public abstract int roll();
}
