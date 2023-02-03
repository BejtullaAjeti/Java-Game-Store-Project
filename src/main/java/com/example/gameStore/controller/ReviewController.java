package com.example.gameStore.controller;

import com.example.gameStore.pojo.Review;
import com.example.gameStore.pojo.ReviewInput;
import com.example.gameStore.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/review")
public class ReviewController {

    private final ReviewService reviewService;
    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping(path = "/store/{gameId}")
    public Review addReview(
            @PathVariable Integer gameId,
            @RequestBody ReviewInput input){
            return reviewService.addNewReview(gameId,input);
    }
}
