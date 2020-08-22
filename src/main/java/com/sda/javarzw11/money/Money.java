package com.sda.javarzw11.money;

import java.math.BigDecimal;

public class Money {
    BigDecimal amount = BigDecimal.ZERO;

    public Money() { }

    public Money(BigDecimal amount) {
        this.amount = amount;
    }

    public Money(int amount) {
        this(BigDecimal.valueOf(amount));
    }

    public Money(double amount) {
        this(BigDecimal.valueOf(amount));
    }

    public void addMoney(Money other) {
        amount = amount.add(other.amount);
    }

    public void subtractMoney(Money other) {
        amount = amount.subtract(other.amount);
    }

    public String toString() {
        return String.format("%s PLN", amount.toString());
    }
}
