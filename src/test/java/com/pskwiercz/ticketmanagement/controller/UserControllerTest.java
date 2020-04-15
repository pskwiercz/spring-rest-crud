package com.pskwiercz.ticketmanagement.controller;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserControllerTest {

    @Autowired
    private WebApplicationContext ctx;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.ctx).build();
    }

    @Test
    public void testGetAllUsers() throws Exception {
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.get("/user"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].username", is("David")))
                .andReturn();
        String content = result.getResponse().getContentAsString();
        System.out.println("Response : " + content);
    }

    @Test
    public void testGetUsers() throws Exception {
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.get("/user/102"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username", is("John")))
                .andExpect(jsonPath("$.userid", is(102)))
                .andReturn();
        String content = result.getResponse().getContentAsString();
        System.out.println("Response : " + content);
    }

}
