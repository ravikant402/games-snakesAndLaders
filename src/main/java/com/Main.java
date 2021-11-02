package com;

import com.model.Board;
import com.model.Player;
import com.dice.Dice;
import com.service.DiceFactory;
import com.service.SnakeFactory;
import com.service.SnakesAndLaddersService;
import com.snake.GreenSnake;
import com.snake.Snake;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Snake> snakes = new ArrayList<>();
        Map<Integer, Integer> ladders = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the your name.");
        Player player = new Player(sc.next());

        System.out.println("Enter size of the Board.");
        int boardSize = sc.nextInt();

        setSnakesPositions(snakes, sc, boardSize);
        setLaddersPositions(ladders, sc, boardSize);

        Board board = new Board(boardSize, player, snakes, ladders);
        Dice dice = getDice(sc);
        SnakesAndLaddersService snakesAndLaddersService = new SnakesAndLaddersService(board, dice);
        snakesAndLaddersService.startGame(sc);

    }

    private static Dice getDice(Scanner sc) {
        DiceFactory diceFactory = new DiceFactory();
        System.out.println("Enter 0 for Normal Dice, else Crooked Dice");
        int diceType = sc.nextInt();
        return diceFactory.getDice(diceType);
    }

    private static void setSnakesPositions(List<Snake> snakes, Scanner sc, int boardSize) {
        System.out.println("Enter number of snakes");
        int noOfSnakes = sc.nextInt();

        for(int i=0;i<noOfSnakes;i++) {


            int start;
            do {
                System.out.println("Enter snake: " + (i+1) +" head position. Should be greater than equal to 2 and lesser than board size");
                start = sc.nextInt();
            } while (start < 2 || start >= boardSize);

            int end;
            do {
                System.out.println("Enter snake: " + (i+1) + " tail position. Tail position should be lesser than the head position. Should be greater than 0.");
                end = sc.nextInt();
            } while (end >= start || end <= 0);

            sc.nextLine();
            System.out.println("Enter 'n'/'N' for Normal Snake, else Green Snake");
            SnakeFactory snakeFactory = new SnakeFactory();
            Snake snake = snakeFactory.getSnake(sc.nextLine(), start, end);

            if(snake instanceof GreenSnake) {
                System.out.println("Enter the number of bites to get to tail.");
                ((GreenSnake) snake).setBites(sc.nextInt());
            }
            snakes.add(snake);
        }
    }

    private static void setLaddersPositions(Map<Integer, Integer> ladders, Scanner sc, int boardSize) {
        System.out.println("Enter number of ladders.");
        int noOfLadders = sc.nextInt();
        for(int i=0;i<noOfLadders;i++) {
            int start;
            do {
                System.out.println("Enter ladder: " + (i+1) +" head position. Should be greater than 1 and less than board size");
                start = sc.nextInt();
            } while (start <= 1 || start > boardSize - 1 );

            int end;
            do {
                System.out.println("Enter ladder: " + (i+1) +" tail position. Tail position should be grater than the head position and less than or equal to the board size.");
                end = sc.nextInt();
            } while (end <= start || end > boardSize);

            ladders.put(start, end);
        }
    }
}
