package com.sda.javarzw11.money;

import com.sda.javarzw11.money.exceptions.IncompatibleCurrencyException;
import com.sda.javarzw11.money.exceptions.InvalidAmountException;
import com.sda.javarzw11.money.exceptions.NotEnoughMoneyException;

import java.math.BigDecimal;

public class Money {
    private BigDecimal amount = BigDecimal.ZERO;
    private Currency currency;

    public Money(Currency currency) {
        this.currency = currency;
    }

    public Money(BigDecimal amount, Currency currency) {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new InvalidAmountException();
        }
        this.amount = amount;
        this.currency = currency;
    }

    public Money(int amount, Currency currency) {
        this(BigDecimal.valueOf(amount), currency);
    }

    public Money(double amount, Currency currency) {
        this(BigDecimal.valueOf(amount), currency);
    }

    public void addMoney(Money other) {
        checkCurrency(other);
        amount = amount.add(other.amount);
    }

    public void subtractMoney(Money other) throws NotEnoughMoneyException {
        checkCurrency(other);
        if (amount.compareTo(other.amount) < 0) {
            throw new NotEnoughMoneyException();
        }
        amount = amount.subtract(other.amount);
    }

    public Currency getCurrency() {
        return currency;
    }

    public String toString() {
        return String.format("%s %s", amount.toString(), currency);
    }

    private void checkCurrency(Money other) {
        if (!currency.equals(other.currency)) {
            throw new IncompatibleCurrencyException();
        }
    }
}
