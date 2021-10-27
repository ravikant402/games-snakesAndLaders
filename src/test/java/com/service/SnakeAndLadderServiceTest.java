package com.service;

import com.model.Board;
import com.model.Player;

import org.junit.Test;
import org.junit.Assert;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnakeAndLadderServiceTest {


    @Test
    public void test_snakesAndLadderGameFor1PlayerWithNoSnakes() {
        Player player = new Player("Ravi");
        List<Player> players = Arrays.asList(player);
        Board board = new Board(100, players, new HashMap<Integer, Integer>());
        SnakesAndLaddersService snakesAndLaddersService = new SnakesAndLaddersService(board, 1, 6);
        snakesAndLaddersService.startGame();
        Assert.assertEquals(100, player.getPosition());
    }

    @Test
    public void test_snakesAndLadderGameFor1PlayerWithSnakes() {
        Player player1 = new Player("Player1");
        Player player2 = new Player("Player2");
        Player player3 = new Player("Player3");
        Player player4 = new Player("Player4");
        Player player5 = new Player("Player5");
        Player player6 = new Player("Player6");
        List<Player> players = Arrays.asList(player1, player2, player3, player4, player5, player6);
        Map<Integer, Integer> snakes = new HashMap<>();
        snakes.put(14,7);
        Board board = new Board(100, players, snakes);
        SnakesAndLaddersService snakesAndLaddersService = new SnakesAndLaddersService(board, 1, 2);
        snakesAndLaddersService.startGame();
        Assert.assertEquals(14, players.stream()
                .filter(player -> player.getSnakeBitePositions().size() > 0)
                .findFirst().map(player -> player.getSnakeBitePositions().getFirst())
                .get().intValue());
    }
}