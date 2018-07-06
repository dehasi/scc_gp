package me.dehasi.contracts.demo.service;

import me.dehasi.contracts.demo.domain.Bet;
import me.dehasi.contracts.demo.exception.UserNotFoundException;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BetService {

    private static final Bet FOOTBALL = new Bet("football", BigDecimal.ONE);
    private static final Bet HORSES = new Bet("horses", BigDecimal.TEN);
    private static final Bet BOXING = new Bet("boxing", BigDecimal.ONE.add(BigDecimal.ONE));

    private Map<String, List<Bet>> database = new HashMap<>();

    public BetService() {
        database.put("1", Collections.emptyList());
        database.put("2", Collections.singletonList(FOOTBALL));
        database.put("3", Arrays.asList(HORSES, BOXING));
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
