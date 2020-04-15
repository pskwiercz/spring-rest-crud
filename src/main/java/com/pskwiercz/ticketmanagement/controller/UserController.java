package com.pskwiercz.ticketmanagement.controller;

import com.pskwiercz.ticketmanagement.model.User;
import com.pskwiercz.ticketmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ResponseBody
    @RequestMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @ResponseBody
    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        return userService.getUser(id);
    }

    @ResponseBody
    @PostMapping
    public Map<String, Object> createUser(@RequestParam(value="userid") Integer userid,
                                          @RequestParam(value="username") String username) {
        userService.createUser(userid, username);
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("result", "Added");
        return map;
    }

    @ResponseBody
    @PutMapping
    public Map<String, Object> updateUser(@RequestParam(value="userid") Integer userid,
                                          @RequestParam(value="username") String username) {
        userService.updateUser(userid, username);
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("result", "Updated");
        return map;
    }

    @ResponseBody
    @DeleteMapping("/{id}")
    public Map<String, Object> deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("result", "Deleted");
        return map;
    }
}
