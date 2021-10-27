package com;

import com.model.Board;
import com.model.Player;
import com.service.SnakesAndLaddersService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Integer> snakes = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter atleast one player");
        int noOfPlayers = sc.nextInt();
        if (noOfPlayers > 0) {
            List<Player> players = new ArrayList<>();
            for (int i = 0; i < noOfPlayers; i++) {
                players.add(new Player(sc.next()));
            }
            setSnakesPositions(snakes, sc);
            Board board = new Board(100, players, snakes);
            SnakesAndLaddersService snakesAndLaddersService = new SnakesAndLaddersService(board, 1, 6);
            snakesAndLaddersService.startGame();
        }
    }

    private static void setSnakesPositions(Map<Integer, Integer> snakes, Scanner sc) {
        System.out.println("Enter number of snakes");
        int noOfSnakes = sc.nextInt();
        for(int i=0;i<noOfSnakes;i++) {
            System.out.println("Enter snake's head position.");
            int start = sc.nextInt();
            System.out.println("Enter snake's tail position. Tail position should be lesser than the head position");
            int end = sc.nextInt();
            if(end >= start) {
                System.out.println("Entered Snake's tail position is not valid.");
            }
            else {
                snakes.put(start, end);
            }
        }
    }
}
