package com.service;

import com.model.Board;
import com.model.Player;
import com.model.dice.Dice;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class SnakesAndLaddersService {

    private Board board;
    private Queue<Player> players;
    private Dice dice;

    public SnakesAndLaddersService(Board board, Dice dice) {
        this.board = board;
        this.setPlayers(board.getPlayers());
        this.dice = dice;
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

    public void startGame() {
        while (true) {
            int diceValue = dice.roll();
            Player currentPlayer = players.poll();
            move(currentPlayer, diceValue);
            if (isFinalDestination(currentPlayer)) {
                System.out.println(currentPlayer.getName() + " has won.");
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
