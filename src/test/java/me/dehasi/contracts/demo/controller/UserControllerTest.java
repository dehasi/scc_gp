package me.dehasi.contracts.demo.controller;

import me.dehasi.contracts.demo.domain.Bet;
import me.dehasi.contracts.demo.exception.UserNotFoundException;
import me.dehasi.contracts.demo.service.BetService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    private static final Bet FOOTBALL = new Bet("football", BigDecimal.ONE);
    private static final Bet HORSES = new Bet("horses", BigDecimal.TEN);
    private static final Bet BOXING = new Bet("boxing", BigDecimal.ONE.add(BigDecimal.ONE));

    @Autowired
    private WebApplicationContext context;

    @MockBean
    private BetService service;

    private MockMvc mockMvc;

    @Before
    public void setUpMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .build();
    }

    @Before
    public void setUpMocks() {
        when(service.getByUserId(anyString())).thenThrow(UserNotFoundException.class);
        when(service.getByUserId(eq("1"))).thenReturn(Collections.emptyList());
        when(service.getByUserId(eq("2"))).thenReturn(Collections.singletonList(FOOTBALL));
        when(service.getByUserId(eq("3"))).thenReturn(Arrays.asList(HORSES, BOXING));
    }

    @Test
    public void getBets_knownUserNoBets_204() throws Exception {
        mockMvc.perform(get("/bets/{userId}", "1"))
                .andExpect(status().isNoContent());
    }

    @Test
    public void getBets_knownUserHadBets_returnsBets() throws Exception {
        mockMvc.perform(get("/bets/{userId}", "3"))
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", MediaType.APPLICATION_JSON_UTF8.toString()))
                .andExpect(content().string("[{\"sport\":\"horses\",\"amount\":10},{\"sport\":\"boxing\",\"amount\":2}]"));
    }

    @Test
    public void getBets_unknownUser_404() throws Exception {
        mockMvc.perform(get("/bets/{userId}", "42"))
                .andExpect(status().isNotFound());
    }

}
