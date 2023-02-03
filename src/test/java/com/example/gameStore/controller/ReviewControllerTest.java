package com.example.gameStore.controller;

import com.example.gameStore.pojo.Game;
import com.example.gameStore.pojo.Review;
import com.example.gameStore.pojo.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReviewControllerTest {

    Review review = new Review();
    String text = "UNIT TEST REVIEW";
    Integer userId = 1;
    User user = new User(userId,"UNIT TEST","UNIT SURNAME");
    Integer rating = 10;
    Integer gameId = 1;
    Game game = new Game(gameId,"UNIT GAME1","CATE","DEV","PUB",55.0);
    @Test
    void addReview() {
        review = new Review(text,rating, game, user);

    }
}