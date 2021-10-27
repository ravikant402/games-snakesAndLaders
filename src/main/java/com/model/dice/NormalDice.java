package com.model.dice;

public class NormalDice extends Dice {

    public NormalDice(int minDiceValue, int maxDiceValue) {
        super(minDiceValue, maxDiceValue);
    }

    @Override
    public int roll() {
        return random.nextInt((maxDiceValue - minDiceValue) + 1) + minDiceValue;
    }
}
