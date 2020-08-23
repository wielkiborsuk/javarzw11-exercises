package com.sda.javarzw11.money;

import com.sda.javarzw11.money.exceptions.NotEnoughMoneyException;

import java.util.HashMap;
import java.util.Map;

public class Wallet {

    Map<Currency, Money> moneyMap = new HashMap<>();

    public void putInMoney(Money other) {
        getMoneyInCurrency(other.getCurrency()).addMoney(other);
    }

    public void takeOutMoney(Money other) throws NotEnoughMoneyException {
        getMoneyInCurrency(other.getCurrency()).subtractMoney(other);
    }

    private Money getMoneyInCurrency(Currency currency) {
        if (!moneyMap.containsKey(currency)) {
            moneyMap.put(currency, new Money(0, currency));
        }
        return moneyMap.get(currency);
    }

    public String toString() {
        return String.format("Wallet %s", moneyMap.toString());
    }
}
