package com.example.gameStore.repository;


import com.example.gameStore.pojo.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GameRepository extends JpaRepository<Game,Integer> {
    Optional<Game> findGameByName(String name);
    Game findGameById(Integer gameId);
}
