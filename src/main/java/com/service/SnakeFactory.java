package com.service;

import com.snake.GreenSnake;
import com.snake.NormalSnake;
import com.snake.Snake;

public class SnakeFactory {

    public Snake getSnake(String type, int head, int tail) {
        if("N".equals(type)) {
            return new NormalSnake(head, tail);
        }
        else {
            return new GreenSnake(head, tail);
        }
    }
}
