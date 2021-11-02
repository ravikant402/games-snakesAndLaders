package com.service;

import com.dice.NormalDice;
import com.model.Board;
import com.model.Player;
import com.snake.GreenSnake;
import com.snake.NormalSnake;
import com.snake.Snake;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class SnakeAndLadderServiceTest {


//    @Test
//    @Ignore
//    public void test_snakesAndLadderGameFor1PlayerWithNoSnakes() {
//        Player player = new Player("Ravi");
//        Board board = new Board(100, player, new HashMap<>(), new HashMap<>());
//        SnakesAndLaddersService snakesAndLaddersService = new SnakesAndLaddersService(board, new NormalDice());
//        snakesAndLaddersService.startGame(new Scanner("n\n"));
//        Assert.assertEquals(100, player.getPosition());
//    }
//
//    @Test
//    public void test_snakesAndLadderGameFor1PlayerWithNoSnakes_10turns() {
//        Player player = new Player("Ravi");
//        Board board = new Board(100, player, new HashMap<>(), new HashMap<>());
//        SnakesAndLaddersService snakesAndLaddersService = new SnakesAndLaddersService(board, new NormalDice());
//        snakesAndLaddersService.startGame(new Scanner("y\nx\n4\nx\n3\nx\n6\nx\n5\nx\n2\nx\n4\nx\n1\nx\n3\nx\n2\nx\n5\ne\n"));
//        Assert.assertEquals(35, player.getPosition());
//    }

    @Test
    @Ignore
    public void test_snakesAndLadderGameFor1PlayerWithSnakes() {
        Player player = new Player("Player1");
        Snake snake1 = new GreenSnake(9, 4);
        Snake snake2 = new NormalSnake(11, 7);
        List<Snake> snakes = Arrays.asList(snake1, snake2);
        Board board = new Board(100, player, snakes, new HashMap<>());
        SnakesAndLaddersService snakesAndLaddersService = new SnakesAndLaddersService(board, new NormalDice());
        snakesAndLaddersService.startGame(new Scanner("y\nx\n4\nx\n3\nx\n6\nx\n1\ne\n"));
        Assert.assertEquals(7, player.getPosition());
        Assert.assertEquals(14, player.getSnakeBitePositions().getFirst().intValue());
    }

//    @Test
//    @Ignore
//    public void test_snakesAndLadderGameFor1PlayerWithSnakesAndLadders_withCrookedDice() {
//        Player player = new Player("Player1");
//        Map<Integer, Integer> snakes = new HashMap<>();
//        snakes.put(14,8);
//        snakes.put(58,24);
//        snakes.put(96,20);
//        Map<Integer, Integer> ladders = new HashMap<>();
//        ladders.put(2,56);
//        ladders.put(4,68);
//        ladders.put(6,32);
//        Board board = new Board(100, player, snakes, ladders);
//        SnakesAndLaddersService snakesAndLaddersService = new SnakesAndLaddersService(board, new CrookedDice());
//        snakesAndLaddersService.startGame(new Scanner("n\n"));
//        Assert.assertEquals(100, player.getPosition());
//        Assert.assertEquals(1, player.getLadderPositions().size());
//    }
}