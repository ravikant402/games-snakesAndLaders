package com.service;

import com.model.Board;
import com.model.Player;
import com.model.dice.CrookedDice;
import com.model.dice.NormalDice;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SnakeAndLadderServiceTest {


    @Test
    public void test_snakesAndLadderGameFor1PlayerWithNoSnakes() {
        Player player = new Player("Ravi");
        Board board = new Board(100, player, new HashMap<>(), new HashMap<>());
        SnakesAndLaddersService snakesAndLaddersService = new SnakesAndLaddersService(board, new NormalDice());
        System.setIn(new ByteArrayInputStream("n\n".getBytes()));
        snakesAndLaddersService.startGame(new Scanner(System.in));
        Assert.assertEquals(100, player.getPosition());
    }

    @Test
    public void test_snakesAndLadderGameFor1PlayerWithNoSnakes_10turns() {
        Player player = new Player("Ravi");
        Board board = new Board(100, player, new HashMap<>(), new HashMap<>());
        SnakesAndLaddersService snakesAndLaddersService = new SnakesAndLaddersService(board, new NormalDice());
        System.setIn(new ByteArrayInputStream("y\nx\n4\nx\n3\nx\n6\nx\n5\nx\n2\nx\n4\nx\n1\nx\n3\nx\n2\nx\n5\ne\n".getBytes()));
        snakesAndLaddersService.startGame(new Scanner(System.in));
        Assert.assertEquals(35, player.getPosition());
    }

    @Test
    public void test_snakesAndLadderGameFor1PlayerWithSnakes() {
        Player player = new Player("Player1");
        Map<Integer, Integer> snakes = new HashMap<>();
        snakes.put(14,7);
        Board board = new Board(100, player, snakes, new HashMap<>());
        SnakesAndLaddersService snakesAndLaddersService = new SnakesAndLaddersService(board, new NormalDice());
        System.setIn(new ByteArrayInputStream("y\nx\n4\nx\n3\nx\n6\nx\n1\ne\n".getBytes()));
        snakesAndLaddersService.startGame(new Scanner(System.in));
        Assert.assertEquals(7, player.getPosition());
        Assert.assertEquals(14, player.getSnakeBitePositions().getFirst().intValue());
    }

    @Test
    public void test_snakesAndLadderGameFor1PlayerWithSnakesAndLadders_withCrookedDice() {
        Player player = new Player("Player1");
        Map<Integer, Integer> snakes = new HashMap<>();
        snakes.put(14,8);
        snakes.put(59,24);
        snakes.put(96,20);
        Map<Integer, Integer> ladders = new HashMap<>();
        ladders.put(2,56);
        ladders.put(4,68);
        ladders.put(6,32);
        Board board = new Board(100, player, snakes, ladders);
        SnakesAndLaddersService snakesAndLaddersService = new SnakesAndLaddersService(board, new CrookedDice());
        System.setIn(new ByteArrayInputStream("n\n".getBytes()));
        snakesAndLaddersService.startGame(new Scanner(System.in));
        Assert.assertEquals(100, player.getPosition());
        Assert.assertEquals(1, player.getLadderPositions().size());
    }
}