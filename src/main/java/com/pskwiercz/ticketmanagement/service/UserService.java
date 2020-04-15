package com.pskwiercz.ticketmanagement.service;

import com.pskwiercz.ticketmanagement.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUser(Integer id);

    void createUser(Integer id, String userName);

    void updateUser(Integer id, String userName);

    void deleteUser(Integer id);
}
