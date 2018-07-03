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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {

    private final BetService service;
    private final RestTemplate restTemplate;

    public UserController(BetService service, RestTemplate restTemplate) {
        this.service = service;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/bets/{userId}")
    public ResponseEntity<List<Bet>> getBets(@PathVariable("userId") String userId) {
        if(!isUsetExists(userId)) {
            return ResponseEntity.notFound().build();
        }
        List<Bet> bets = service.getByUserId(userId);
        if (bets.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(bets);
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleError(UserNotFoundException ex) {
        // TODO: log exception
    }

    private boolean isUsetExists(String userId) {
        try {
            restTemplate.getForObject("/exists/" + userId, Void.class);
            return true;
        } catch (HttpStatusCodeException ignore) {
            return false;
        }
    }
}
