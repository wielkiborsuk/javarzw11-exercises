package com.sda.javarzw11.money;

public class Person {

    String name;
    Wallet wallet;

    public Person(String name) {
        this.name = name;
        wallet = new Wallet();
    }

    public void giveMoneyToPerson(Money money, Person other) {
        this.wallet.takeOutMoney(money);
        other.receiveMoney(money);
    }

    public void receiveMoney(Money money) {
        this.wallet.putInMoney(money);
    }

    public String toString() {
        return String.format("Person {name=%s, %s}", name, wallet);
    }
}
