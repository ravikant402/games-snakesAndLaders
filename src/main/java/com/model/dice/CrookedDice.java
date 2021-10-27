package com.model.dice;

public class CrookedDice extends Dice {

    public CrookedDice(int minDiceValue, int maxDiceValue) {
        super(minDiceValue, maxDiceValue);
    }

    @Override
    public int roll() {
        minDiceValue = minDiceValue % 2 == 0 ? minDiceValue : minDiceValue + 1;
        maxDiceValue = maxDiceValue % 2 == 0 ? maxDiceValue : maxDiceValue - 1;
        return (random.nextInt(maxDiceValue - minDiceValue + 1) + minDiceValue)/2  * 2;
    }
}
