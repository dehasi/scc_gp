package me.dehasi.contracts.demo.controller;

import me.dehasi.contracts.demo.domain.Bet;
import me.dehasi.contracts.demo.service.BetService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final BetService service;

    public UserController(BetService service) {
        this.service = service;
    }

    @GetMapping("/bets/{userId}")
    public List<Bet> getBets(@PathVariable("userId") String userId) {
        return service.getByUserId(userId);
    }
}
