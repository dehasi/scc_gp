package me.dehasi.contracts.demo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Objects;


public final class Bet {
    public final String sport;
    public final BigDecimal amount;

    @JsonCreator
    public Bet(@JsonProperty("sport") String sport, @JsonProperty("amount") BigDecimal amount) {
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
