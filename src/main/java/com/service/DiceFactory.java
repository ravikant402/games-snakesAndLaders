package com.service;

import com.dice.CrookedDice;
import com.dice.Dice;
import com.dice.NormalDice;

public class DiceFactory {

    public Dice getDice(int diceType) {
        if(diceType == 0) {
            return new NormalDice();
        }
        else {
            return new CrookedDice();
        }
    }
}
