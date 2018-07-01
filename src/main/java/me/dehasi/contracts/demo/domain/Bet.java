package me.dehasi.contracts.demo.domain;

import java.math.BigDecimal;

public final class Bet {
    public final String sport;
    public final BigDecimal amout;

    public Bet(String sport, BigDecimal amout) {
        this.sport = sport;
        this.amout = amout;
    }
}
