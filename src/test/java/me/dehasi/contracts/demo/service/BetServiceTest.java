package me.dehasi.contracts.demo.service;

import me.dehasi.contracts.demo.domain.Bet;
import me.dehasi.contracts.demo.exception.UserNotFoundException;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BetServiceTest {
    private final BetService service = new BetService();


    @Test
    public void getByUserId_UserDoesNotHaveBets_returnsEmptyList() {

        List<Bet> bets = service.getByUserId("1");

        assertThat(bets).isEmpty();
    }

    @Test
    public void getByUserId_knownUser_returnsBets() {
        Bet bet = new Bet("football", BigDecimal.ONE);

        List<Bet> bets = service.getByUserId("2");

        assertThat(bets).containsExactly(bet);
    }

    @Test
    public void getByUserId_userNotExist_throwsException() {
        assertThatThrownBy(() -> service.getByUserId("lol")).isInstanceOf(UserNotFoundException.class);
    }
}
