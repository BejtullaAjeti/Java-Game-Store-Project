package com.example.gameStore.service;

import com.example.gameStore.pojo.User;
import com.example.gameStore.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService (UserRepository userRepository){this.userRepository=userRepository;}

    public List<User> userList() { return userRepository.findAll();}

    public void addUser(User user) {
        userRepository.save(user);
    }

    @Transactional
    public void updateUser(Integer userId, String name, String surname) {
        User user = userRepository.findById(userId).orElseThrow(()-> new IllegalStateException("User with id: " + userId + " doesn't exist!!!"));

        if(name!=null && name.length()>0 && !Objects.equals(user.getName(),name)){
            user.setName(name);
        }
        if(surname!=null && surname.length()>0 && !Objects.equals(user.getSurname(),surname)){
            user.setSurname(surname);
        }
    }

    public void deleteUser(Integer userId) {
        boolean exists = userRepository.existsById(userId);
        if(!exists){
            throw new IllegalStateException(
                    "User with id: " + userId + " doesn't exist");
        }
        userRepository.deleteById(userId);

    }
}
