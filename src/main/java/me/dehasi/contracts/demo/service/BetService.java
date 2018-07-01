package me.dehasi.contracts.demo.service;

import me.dehasi.contracts.demo.domain.Bet;
import me.dehasi.contracts.demo.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class BetService {

    public List<Bet> getByUserId(String userId) {
        switch (userId) {
            case "1" : return Collections.emptyList();
            case "2" : return Collections.emptyList();
            case "3" : return Collections.emptyList();
            default: throw new UserNotFoundException(userId);
        }
    }
}
