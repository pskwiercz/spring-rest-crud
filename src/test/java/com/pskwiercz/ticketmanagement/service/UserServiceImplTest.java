package com.pskwiercz.ticketmanagement.service;

import com.pskwiercz.ticketmanagement.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void testAllUsers() {
        List<User> userlist = userService.getAllUsers();
        assertEquals(3, userlist.size());
    }

    @Test
    public void testGetUser() {
        User user = userService.getUser(100);
        assertEquals("David", user.getUsername());
    }
}