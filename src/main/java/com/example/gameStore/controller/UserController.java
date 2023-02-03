package com.example.gameStore.controller;


import com.example.gameStore.pojo.User;
import com.example.gameStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService storeService) {
        this.userService = storeService;
    }

    @GetMapping
    public List<User> userList(){
        return userService.userList();
    }

    @PostMapping
    public void addNewUser(@RequestBody User user){
        userService.addUser(user);
    }

    @PutMapping(path ="/update/{userId}")
    public void updateUser(
            @PathVariable("userId") Integer userId,
            @RequestBody User user){
        userService.updateUser(userId, user.getName(), user.getSurname());
    }
    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") Integer userId ){
        userService.deleteUser(userId);
    }
}
