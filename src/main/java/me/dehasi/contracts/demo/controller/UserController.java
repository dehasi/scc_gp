package me.dehasi.contracts.demo.controller;

import me.dehasi.contracts.demo.domain.Bet;
import me.dehasi.contracts.demo.exception.UserNotFoundException;
import me.dehasi.contracts.demo.service.BetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {

    private final BetService service;

    public UserController(BetService service) {
        this.service = service;
    }

    @GetMapping("/bets/{userId}")
    public ResponseEntity<List<Bet>> getBets(@PathVariable("userId") String userId) {
        List<Bet> bets = service.getByUserId(userId);
        if (bets.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(bets);
    }

    @PostMapping("/bets/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public void postBet(@PathVariable("userId") String userId, @RequestBody Bet bet) {
        service.addBet(userId, bet);
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleError(UserNotFoundException ex) {
        // TODO: log exception
    }

}
