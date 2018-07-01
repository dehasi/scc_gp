package me.dehasi.contracts.sub.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserExistsController.class)
public class UserExistsControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setUpMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .build();
    }

    @Test
    public void isExists_userExists_200() throws Exception {
        mockMvc.perform(get("/exists/{userId}", "1"))
                .andExpect(status().isOk());
    }

    @Test
    public void isExists_userDoesNotExist_404() throws Exception {
        mockMvc.perform(get("/exists/{userId}", "42"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void isExists_cantParseId_400() throws Exception {
        mockMvc.perform(get("/exists/{userId}", "chuj"))
                .andExpect(status().isBadRequest());
    }

}
