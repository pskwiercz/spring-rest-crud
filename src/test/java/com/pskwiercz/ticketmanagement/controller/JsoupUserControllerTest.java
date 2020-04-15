package com.pskwiercz.ticketmanagement.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.pskwiercz.ticketmanagement.model.User;
import com.pskwiercz.ticketmanagement.service.UserService;
import org.jsoup.Jsoup;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JsoupUserControllerTest {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @Test
    @Ignore
    public void testUsersJsoup() throws IOException {
        // Application must running when test is run
        String doc = Jsoup.connect("http://localhost:8080/user").ignoreContentType(true).get().body().text();
        LOG.info("Result : " + doc);
        JsonParser parser = new JsonParser();
        JsonElement userElement = parser.parse(doc);
        JsonArray userArray = userElement.getAsJsonArray();
        LOG.info("Json size : " + userArray.size());
        assertEquals(4, userArray.size());
    }

    @Test
    @Ignore
    public void testUserJsoup() throws IOException{
        String doc = Jsoup.connect("http://localhost:8080/user/100").ignoreContentType(true).get().body().text();
        LOG.info("Result : " + doc);
        Gson g = new Gson();
        User user = g.fromJson(doc, User.class);
        assertEquals("David", user.getUsername());
    }

    @Test
    @Ignore
    public void testUserAdditionJsoup() throws IOException{
        String doc = Jsoup.connect("http://localhost:8080/user/")
                .data("userid", "103")
                .data("username", "kevin")
                .ignoreContentType(true)
                .post().body().text();
        Gson g = new Gson();
        Map<String, Object> result = g.fromJson(doc, Map.class);
        LOG.info("Result : " + result);
        assertEquals("Added", result.get("result"));
        // user should be deleted as we tested the case already
        userService.deleteUser(103);
    }
}
