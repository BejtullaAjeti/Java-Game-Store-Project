package com.example.gameStore.service;


import com.example.gameStore.pojo.Game;
import com.example.gameStore.pojo.Review;
import com.example.gameStore.pojo.ReviewInput;
import com.example.gameStore.pojo.User;
import com.example.gameStore.repository.GameRepository;
import com.example.gameStore.repository.ReviewRepository;
import com.example.gameStore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ReviewService {
    @Autowired
    private  ReviewRepository reviewRepository;
    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private  GameRepository gameRepository;



    public Review addNewReview(Integer gameId, ReviewInput input) {
        User user = userRepository.findUserById(input.getUserId());
        Game game = gameRepository.findGameById(gameId);
        Review review = new Review();
        review.setText(input.getText());
        review.setRating(input.getRating());
        review.setUser(user);
        review.setGame(game);
        return reviewRepository.save(review);
    }

}
