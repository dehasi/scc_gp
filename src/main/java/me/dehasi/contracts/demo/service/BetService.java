package me.dehasi.contracts.demo.service;

import static java.util.Arrays.asList;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import me.dehasi.contracts.demo.domain.Bet;
import me.dehasi.contracts.demo.exception.UserNotFoundException;

@Service
public class BetService {

    private static final Bet FOOTBALL = new Bet("football", BigDecimal.ONE);
    private static final Bet HORSES = new Bet("horses", BigDecimal.TEN);
    private static final Bet BOXING = new Bet("boxing", BigDecimal.ONE.add(BigDecimal.ONE));

    private Map<String, List<Bet>> database = new HashMap<>();

    public BetService() {
        database.put("1", new ArrayList<>());
        database.put("2", new ArrayList<>(Collections.singletonList(FOOTBALL)));
        database.put("3", new ArrayList<>(asList(HORSES, BOXING)));
    }

    public List<Bet> getByUserId(String userId) {
        if (!database.containsKey(userId)) {
            throw new UserNotFoundException(userId);
        }
        return database.get(userId);
    }

    public void addBet(String userId, Bet bet){
        if (!database.containsKey(userId)) {
            throw new UserNotFoundException(userId);
        }
        database.get(userId).add(bet);
    }
}
