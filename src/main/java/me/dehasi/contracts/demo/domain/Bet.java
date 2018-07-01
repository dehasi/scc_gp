package me.dehasi.contracts.demo.domain;

import java.math.BigDecimal;
import java.util.Objects;

public final class Bet {
    public final String sport;
    public final BigDecimal amount;

    public Bet(String sport, BigDecimal amount) {
        this.sport = sport;
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bet bet = (Bet) o;

        return Objects.equals(sport, bet.sport)
                && Objects.equals(amount, bet.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sport, amount);
    }
}
