package me.dehasi.contracts.demo.service;

import me.dehasi.contracts.demo.domain.Bet;
import me.dehasi.contracts.demo.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class BetService {

    private static final Bet FOOTBALL = new Bet("football", BigDecimal.ONE);
    private static final Bet HORSES = new Bet("horses", BigDecimal.TEN);
    private static final Bet BOXING = new Bet("boxing", BigDecimal.ONE.add(BigDecimal.ONE));

    public List<Bet> getByUserId(String userId) {
        switch (userId) {
            case "1":
                return Collections.emptyList();
            case "2":
                return Collections.singletonList(FOOTBALL);
            case "3":
                return Arrays.asList(HORSES, BOXING);
            default:
                throw new UserNotFoundException(userId);
        }
    }
}
