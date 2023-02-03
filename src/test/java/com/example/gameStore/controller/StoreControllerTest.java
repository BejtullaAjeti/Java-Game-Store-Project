package com.example.gameStore.controller;

import com.example.gameStore.pojo.Game;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StoreControllerTest {
    Game game = new Game();

    @Test
    void addNewGame() {
        game = new Game("UNIT GAME1","CATE","DEV","PUB",55.0);
    }

    @Test
    void updateGame() {
        game.setName("UNIT UPDATE");
    }

}