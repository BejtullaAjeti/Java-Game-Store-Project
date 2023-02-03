package com.example.gameStore.service;


import com.example.gameStore.pojo.Game;
import com.example.gameStore.repository.GameRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StoreService {

    private final GameRepository gameRepository;

    @Autowired
    public StoreService(GameRepository gameRepository){
        this.gameRepository=gameRepository;
    }

    public List<Game> gameList(){
        return  gameRepository.findAll();
    }

    public void addGame(Game game) {
        Optional<Game> gameByName = gameRepository.findGameByName(game.getName());
        if(gameByName.isPresent()){
            throw  new IllegalStateException("Game already registered!");
        }
        gameRepository.save(game);
    }

    @Transactional
    public void updateGame(Integer gameId, String name, String categories, String developer, String publisher, Double price) {
        Game game = gameRepository.findById(gameId).orElseThrow(()-> new IllegalStateException("Game with id: " + gameId + " doesn't exist!!!"));

        if(name!=null && name.length()>0 && !Objects.equals(game.getName(),name)){
            game.setName(name);
        }
        if(categories!=null && categories.length()>0 && !Objects.equals(game.getCategories(),categories)){
            game.setCategories(categories);
        }
        if(developer!=null && developer.length()>0 && !Objects.equals(game.getDeveloper(),developer)){
            game.setDeveloper(developer);
        }
        if(publisher!=null && publisher.length()>0 && !Objects.equals(game.getPublisher(),publisher)){
            game.setPublisher(publisher);
        }
        if(price!=null && !Objects.equals(game.getPrice(),price)){
            game.setPrice(price);
        }
    }

    public void deleteGame(Integer gameId) {
        boolean exists = gameRepository.existsById(gameId);
        if(!exists){
            throw new IllegalStateException(
                    "Game with id: " + gameId + " doesn't exist"
            );
        }
        gameRepository.deleteById(gameId);
    }
}
