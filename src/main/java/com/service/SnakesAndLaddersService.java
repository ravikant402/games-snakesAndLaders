package com.service;

import com.model.Board;
import com.model.Player;
import com.model.dice.Dice;
import com.model.dice.NormalDice;

import java.util.Map;
import java.util.Scanner;

public class SnakesAndLaddersService {

    private Board board;
    private Player player;
    private Dice dice;

    public SnakesAndLaddersService(Board board, Dice dice) {
        this.board = board;
        this.player = board.getPlayer();
        this.dice = dice;
    }

    private void move(Player player, int diceValue) {
        int position = player.getPosition();
        System.out.println(player.getName() + " at " + position);
        System.out.println(player.getName() + " rolled " + diceValue);
        if(position + diceValue <= board.getSize()) {
            position += diceValue;
        }
        else {
            System.out.println(player.getName() + " cannot moved out of the board. \nStay at current position.");
        }
        updatePositionIfBitBySnakeOrTakesLadder(position, player);
        System.out.println(player.getName() + " moved to " + player.getPosition());
    }

    private void updatePositionIfBitBySnakeOrTakesLadder(int position, Player player) {
        int prePosition = -1;
        while(prePosition != position) {
            prePosition = position;
            Map<Integer, Integer> snakes = board.getSnakes();
            if(snakes.containsKey(position)) {
                position = snakes.get(position);
                player.setPosition(position);
                player.addSnakeBitePosition(prePosition);
                System.out.println(player.getName() + " got bit by snake. Goto position: " + position);
            }
            Map<Integer, Integer> ladders = board.getLadders();
            if(ladders.containsKey(position)) {
                position = ladders.get(position);
                player.setPosition(position);
                player.addLadderTookPosition(prePosition);
                System.out.println(player.getName() + " got a ladder. Goto position: " + position);
            }
        }
        player.setPosition(position);
    }

    private boolean isFinalDestination(Player player) {
        if(player.getPosition() == board.getSize()) {
            return true;
        }
        return false;
    }

    public void startGame(Scanner sc) {
        boolean moreTurns = true;
        System.out.println("Press 'y' for testing mode, else game mode.");
        boolean mode = sc.hasNext("y");
        sc.next();
        while (moreTurns) {
            int diceValue = 0;
            if(mode) {
                System.out.println("Enter 'e' to exit");
                if ("e".equals(sc.next())) {
                    break;
                }
                if (dice instanceof NormalDice) {
                    do{
                        System.out.println("Press a number between 1-6 for a dice value.");
                        diceValue = sc.nextInt();
                    } while(diceValue > 6 || diceValue < 1);

                }
                else {
                    do {
                        System.out.println("Press even number between 1-6 for dice value.");
                        diceValue = sc.nextInt();
                    } while(diceValue % 2 != 0 || diceValue > 6 || diceValue < 1);
                }

            }
            else {
                diceValue = dice.roll();
            }

            move(player, diceValue);
            if (isFinalDestination(player)) {
                System.out.println(player.getName() + " has won.");
                moreTurns = false;
            }
        }
    }
}
