package com.example.gameStore.pojo;

public class ReviewInput {


        private String text;

        private Integer rating;
        private Integer userId;
        private Integer gameId;

    public ReviewInput(String text, Integer rating, Integer userId, Integer gameId) {
        this.text = text;
        this.rating = rating;
        this.userId = userId;
        this.gameId = gameId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }
}
