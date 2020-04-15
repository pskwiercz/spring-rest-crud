package com.pskwiercz.ticketmanagement.service;

import com.pskwiercz.ticketmanagement.model.User;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public User getUser(Integer id) {
        return users.stream()
                .filter(user -> user.getUserid() == id)
                .findAny()
                .orElse(new User(0, "Not Found"));
    }

    @Override
    public void createUser(Integer id, String userName) {
        User newUser = new User(id, userName);
        users.add(newUser);
    }

    @Override
    public void updateUser(Integer id, String userName) {
        users.stream()
                .filter(user -> user.getUserid() == id)
                .findAny()
                .orElseThrow(() -> new RuntimeException("User not found"))
                .setUsername(userName);
    }

    @Override
    public void deleteUser(Integer id) {
        users.removeIf(user -> user.getUserid() == id);
    }

    // Dummy users
    public static List<User> users;

    public UserServiceImpl() {
        users = new LinkedList<>();
        users.add(new User(100, "David"));
        users.add(new User(101, "Peter"));
        users.add(new User(102, "John"));
    }
}
