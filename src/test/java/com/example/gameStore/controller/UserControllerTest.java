package com.example.gameStore.controller;

import com.example.gameStore.pojo.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {
    User user = new User();
    @Test
    void addNewUser() {
        user = new User("UNIT USER","UNIT SURNAME");
    }

    @Test
    void updateUser() {
        user.setSurname("UNIT UPDATE");
    }

}