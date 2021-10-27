package com.service;

import com.model.Board;
import com.model.Player;

import org.junit.Test;
import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

public class SnakeAndLadderServiceTest {


    @Test
    public void test_snakesAndLadderGameFor1Player() {
        Player player = new Player("Ravi");
        List<Player> players = Arrays.asList(player);
        Board board = new Board(100, players);
        SnakeAndLadderService snakeAndLadderService = new SnakeAndLadderService(board);
        snakeAndLadderService.startGame();
        Assert.assertEquals(100, player.getPosition());
    }
}