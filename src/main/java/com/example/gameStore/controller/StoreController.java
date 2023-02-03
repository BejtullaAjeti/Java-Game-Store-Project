package com.example.gameStore.controller;



import com.example.gameStore.pojo.Game;
import com.example.gameStore.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/store")
public class StoreController {
    private final StoreService storeService;

    @Autowired
    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping
    public List<Game> gameList(){
        return storeService.gameList();
    }

    @PostMapping
    public void addNewGame(@RequestBody Game game){
        storeService.addGame(game);
    }

    @PutMapping(path ="/update/{gameId}")
    public void updateGame(
            @PathVariable("gameId") Integer gameId,
            @RequestBody Game game){
            storeService.updateGame(gameId,game.getName(),game.getCategories(),game.getDeveloper(),game.getPublisher(),game.getPrice());
    }


    @DeleteMapping(path = "{gameId}")
    public void deleteGame(@PathVariable("gameId") Integer gameId ){
        storeService.deleteGame(gameId);
    }

}
