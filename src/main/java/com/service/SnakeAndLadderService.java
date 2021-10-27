package com.service;

import com.model.Board;
import com.model.Player;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class SnakeAndLadderService {

    private Board board;
    private Queue<Player> players;
    private Random random = new Random();

    private static final int maxDiceValue = 6;
    private static final int minDiceValue = 1;

    public SnakeAndLadderService(Board board) {
        this.board = board;
        this.setPlayers(board.getPlayers());
    }

    private void setPlayers(List<Player> players) {
        this.players = new LinkedList<>();
        this.players.addAll(players);
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
        player.setPosition(position);
        System.out.println(player.getName() + " moved to " + position);
    }

    private int diceRoll() {
        return random.nextInt((maxDiceValue - minDiceValue) + 1) + minDiceValue;
    }

    private boolean isFinalDestination(Player player) {
        if(player.getPosition() == board.getSize()) {
            return true;
        }
        return false;
    }

    public void startGame() {
        while (true) {
            int diceValue = diceRoll();
            Player currentPlayer = players.poll();
            move(currentPlayer, diceValue);
            if (isFinalDestination(currentPlayer)) {
                System.out.println(currentPlayer.getName() + " has won");
                players.clear();
            }
            else {
                players.add(currentPlayer);
            }
            if (players.isEmpty()) {
                break;
            }
        }
    }
}
