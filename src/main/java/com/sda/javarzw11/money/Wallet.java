package com.sda.javarzw11.money;

public class Wallet {

    Money money = new Money();

    public void putInMoney(Money other) {
        money.addMoney(other);
    }

    public void takeOutMoney(Money other) {
        money.subtractMoney(other);
    }

    public String toString() {
        return String.format("Wallet {%s}", money.toString());
    }
}
