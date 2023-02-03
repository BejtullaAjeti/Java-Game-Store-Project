package com.example.gameStore.repository;



import com.example.gameStore.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository  extends JpaRepository<User,Integer> {
    User findUserById(Integer userId);
}
