package com.service;

import com.model.dice.CrookedDice;
import com.model.dice.Dice;
import com.model.dice.NormalDice;

public class DiceFactory {

    public Dice getDice(int diceType, int minDiceValue, int maxDiceValue) {
        if(diceType == 0) {
            return new NormalDice(minDiceValue, maxDiceValue);
        }
        else {
            return new CrookedDice(minDiceValue, maxDiceValue);
        }
    }
}
