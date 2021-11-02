package com.dice;

public class CrookedDice extends Dice {

    public CrookedDice() {
    }

    @Override
    public int roll() {
        int minValue = minDiceValue % 2 == 0 ? minDiceValue : minDiceValue + 1;
        int maxValue = maxDiceValue % 2 == 0 ? maxDiceValue : maxDiceValue - 1;
        return (random.nextInt(maxValue - minValue + 1) + minValue)/2  * 2;
    }
}
