package com.service;

import com.model.dice.CrookedDice;
import com.model.dice.Dice;
import com.model.dice.NormalDice;

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
