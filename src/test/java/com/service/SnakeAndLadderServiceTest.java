package com.service;

import com.model.Board;
import com.model.Player;
import com.model.dice.CrookedDice;
import com.model.dice.NormalDice;

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
        Board board = new Board(100, players, new HashMap<>(), new HashMap<>());
        SnakesAndLaddersService snakesAndLaddersService = new SnakesAndLaddersService(board, new NormalDice(1, 6));
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
        Player player7 = new Player("Player7");
        Player player8 = new Player("Player8");
        Player player9 = new Player("Player9");
        Player player10 = new Player("Player10");
        List<Player> players = Arrays.asList(player1, player2, player3, player4, player5, player6, player7, player8, player9, player10);
        Map<Integer, Integer> snakes = new HashMap<>();
        snakes.put(14,7);
        Board board = new Board(100, players, snakes, new HashMap<>());
        SnakesAndLaddersService snakesAndLaddersService = new SnakesAndLaddersService(board, new NormalDice(1, 2));
        snakesAndLaddersService.startGame();
        Assert.assertEquals(1, players.stream().filter(player -> player.getPosition() == 100).count());
        Assert.assertEquals(14, players.stream()
                .filter(player -> player.getSnakeBitePositions().size() > 0)
                .findFirst().map(player -> player.getSnakeBitePositions().getFirst())
                .get().intValue());
    }

    @Test
    public void test_snakesAndLadderGameFor1PlayerWithSnakesAndLadders() {
        Player player1 = new Player("Player1");
        Player player2 = new Player("Player2");
        Player player3 = new Player("Player3");
        Player player4 = new Player("Player4");
        Player player5 = new Player("Player5");
        Player player6 = new Player("Player6");
        List<Player> players = Arrays.asList(player1, player2, player3, player4, player5, player6);
        Map<Integer, Integer> snakes = new HashMap<>();
        snakes.put(14,7);
        snakes.put(59,24);
        snakes.put(96,20);
        Map<Integer, Integer> ladders = new HashMap<>();
        ladders.put(36,84);
        ladders.put(3,45);
        ladders.put(63,94);
        Board board = new Board(100, players, snakes, ladders);
        SnakesAndLaddersService snakesAndLaddersService = new SnakesAndLaddersService(board, new NormalDice(1, 6));
        snakesAndLaddersService.startGame();
        Assert.assertEquals(1, players.stream().filter(player -> player.getPosition() == 100).count());
    }

    @Test
    public void test_snakesAndLadderGameFor1PlayerWithSnakesAndLadders_withCrookedDice() {
        Player player1 = new Player("Player1");
        Player player2 = new Player("Player2");
        Player player3 = new Player("Player3");
        Player player4 = new Player("Player4");
        Player player5 = new Player("Player5");
        Player player6 = new Player("Player6");
        List<Player> players = Arrays.asList(player1, player2, player3, player4, player5, player6);
        Map<Integer, Integer> snakes = new HashMap<>();
        snakes.put(14,7);
        snakes.put(59,24);
        snakes.put(96,20);
        Map<Integer, Integer> ladders = new HashMap<>();
        ladders.put(36,84);
        ladders.put(3,45);
        ladders.put(63,94);
        Board board = new Board(100, players, snakes, ladders);
        SnakesAndLaddersService snakesAndLaddersService = new SnakesAndLaddersService(board, new CrookedDice(1, 6));
        snakesAndLaddersService.startGame();
        Assert.assertEquals(1, players.stream().filter(player -> player.getPosition() == 100).count());
    }
}