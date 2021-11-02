package com.dice;

public class NormalDice extends Dice {
    @Override
    public int roll() {
        return random.nextInt((maxDiceValue - minDiceValue) + 1) + minDiceValue;
    }
}
