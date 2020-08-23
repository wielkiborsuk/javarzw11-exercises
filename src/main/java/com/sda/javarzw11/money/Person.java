package com.sda.javarzw11.money;

import com.sda.javarzw11.money.exceptions.NotEnoughMoneyException;

public class Person {

    String name;
    Wallet wallet;

    public Person(String name) {
        this.name = name;
        wallet = new Wallet();
    }

    public void giveMoneyToPerson(Money money, Person other) {
        try {
            this.wallet.takeOutMoney(money);
            other.receiveMoney(money);
        } catch (NotEnoughMoneyException e) {
            System.out.println("coudn't pay");
        }
    }

    public void receiveMoney(Money money) {
        this.wallet.putInMoney(money);
    }

    public String toString() {
        return String.format("Person {name=%s, %s}", name, wallet);
    }
}
