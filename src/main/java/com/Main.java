package com;

import com.model.Board;
import com.model.Player;
import com.service.SnakeAndLadderService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter atleast one player");
        int noOfPlayers = sc.nextInt();
        if (noOfPlayers > 0) {
            List<Player> players = new ArrayList<>();
            for (int i = 0; i < noOfPlayers; i++) {
                players.add(new Player(sc.next()));
            }
            Board board = new Board(100, players);
            SnakeAndLadderService snakeAndLadderService = new SnakeAndLadderService(board);
            snakeAndLadderService.startGame();
        }
    }
}
