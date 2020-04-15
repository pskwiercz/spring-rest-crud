package com.pskwiercz.ticketmanagement.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @ResponseBody
    @RequestMapping("")
    public Map<String, Object> getAllUsers() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("result", "Get All Users Implementation");
        return map;
    }

    @ResponseBody
    @GetMapping("/{id}")
    public Map<String, Object> getUser(@PathVariable("id") Integer id) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("result", "Get User Implementation");
        return map;
    }

    @ResponseBody
    @PostMapping()
    public Map<String, Object> createUser() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("result", "Create User Implementation");
        return map;
    }

    @ResponseBody
    @PutMapping()
    public Map<String, Object> updateUser() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("result", "Update User Implementation");
        return map;
    }

    @ResponseBody
    @DeleteMapping()
    public Map<String, Object> deleteUser() {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("result", "Delete User Implementation");
        return map;
    }
}
