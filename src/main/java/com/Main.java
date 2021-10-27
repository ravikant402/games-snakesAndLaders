package com;

import com.model.Board;
import com.model.Player;
import com.model.dice.Dice;
import com.service.DiceFactory;
import com.service.SnakesAndLaddersService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Integer> snakes = new HashMap<>();
        Map<Integer, Integer> ladders = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter atleast one player");
        int noOfPlayers = sc.nextInt();
        if (noOfPlayers > 0) {
            List<Player> players = new ArrayList<>();
            for (int i = 0; i < noOfPlayers; i++) {
                players.add(new Player(sc.next()));
            }

            System.out.println("Enter size of the Board. Odd board size will result in using the default Normal dice");
            int boardSize = sc.nextInt();

            setSnakesPositions(snakes, sc, boardSize);
            setLaddersPositions(ladders, sc, boardSize);

            Board board = new Board(boardSize, players, snakes, ladders);
            Dice dice = getDice(sc, boardSize);
            SnakesAndLaddersService snakesAndLaddersService = new SnakesAndLaddersService(board, dice);
            snakesAndLaddersService.startGame();
        }
    }

    private static Dice getDice(Scanner sc, int boardSize) {
        DiceFactory diceFactory = new DiceFactory();

        int diceType;
        if (boardSize % 2 != 0) {
            System.out.println("Your board size is odd. Playing with Crooked dice cannot end up in a winner. Therefore taking the Normal dice.");
            diceType = 0;
        }
        else{
            System.out.println("Enter 0 for Normal Dice, else Crooked Dice");
            diceType = sc.nextInt();
        }

        int minDiceValue;
        do {
            System.out.println("Enter minimun dice value. Should be greater than 0.");
            minDiceValue = sc.nextInt();
        } while (minDiceValue <= 0 || minDiceValue >= boardSize - 1);

        int maxDiceValue;
        do {
            System.out.println("Enter maximum dice value. Should be less than the board size.");
            maxDiceValue = sc.nextInt();
        } while (maxDiceValue > boardSize || maxDiceValue <= minDiceValue);
        return diceFactory.getDice(diceType, minDiceValue, maxDiceValue);
    }

    private static void setSnakesPositions(Map<Integer, Integer> snakes, Scanner sc, int boardSize) {
        System.out.println("Enter number of snakes");
        int noOfSnakes = sc.nextInt();

        for(int i=0;i<noOfSnakes;i++) {
            int start;
            do {
                System.out.println("Enter snake's head position. Should be greater than equal to 2 and lesser than board size");
                start = sc.nextInt();
            } while (start < 2 || start >= boardSize);

            int end;
            do {
                System.out.println("Enter snake's tail position. Tail position should be lesser than the head position. Should be greater than 0.");
                end = sc.nextInt();
            } while (end >= start || end <= 0);

            snakes.put(start, end);
        }
    }

    private static void setLaddersPositions(Map<Integer, Integer> ladders, Scanner sc, int boardSize) {
        System.out.println("Enter number of ladders.");
        int noOfLadders = sc.nextInt();
        for(int i=0;i<noOfLadders;i++) {
            int start;
            do {
                System.out.println("Enter ladder's head position. Should be greater than 1 and less than board size");
                start = sc.nextInt();
            } while (start <= 1 || start > boardSize - 1 );

            int end;
            do {
                System.out.println("Enter ladder's tail position. Tail position should be grater than the head position and less than or equal to the board size.");
                end = sc.nextInt();
            } while (end <= start || end > boardSize);

            ladders.put(start, end);
        }
    }
}
