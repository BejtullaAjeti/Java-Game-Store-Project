package com.example.gameStore.pojo;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="categories")
    private String categories;

    @Column(name="developer")
    private String developer;

    @Column(name="publisher")
    private String publisher;

    @Column(name="price")
    private Double price;

    @OneToMany(mappedBy = "game")
    @JsonManagedReference
    private List<Review> reviews;




    public Game(Integer id, String name, String categories, String developer, String publisher, Double price) {
        this.id = id;
        this.name = name;
        this.categories = categories;
        this.developer = developer;
        this.publisher = publisher;
        this.price = price;
        this.reviews = new ArrayList<>();
    }

    public Game(String name, String categories, String developer, String publisher, Double price) {
        this.name = name;
        this.categories = categories;
        this.developer = developer;
        this.publisher = publisher;
        this.price = price;
        this.reviews = new ArrayList<>();
    }

    public Game() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String category) {
        this.categories = category;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", categories='" + categories + '\'' +
                ", developer='" + developer + '\'' +
                ", publisher='" + publisher + '\'' +
                ", price=" + price +
                ", reviews=" + reviews +
                '}';
    }
}
