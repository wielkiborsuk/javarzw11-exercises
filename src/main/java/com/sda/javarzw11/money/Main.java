package com.sda.javarzw11.money;

import com.sda.javarzw11.money.exceptions.ItemNotFoundException;
import com.sda.javarzw11.money.exceptions.NotEnoughMoneyException;

public class Main {

    public static void main(String[] args) throws NotEnoughMoneyException, ItemNotFoundException {
        Person andrzej = new Person("Andrzej");
        Person kazimierz = new Person("Kazimierz");
        System.out.println(andrzej);
        System.out.println(kazimierz);

        andrzej.receiveMoney(new Money(10, Currency.PLN));
        kazimierz.receiveMoney(new Money(40, Currency.PLN));
        kazimierz.receiveMoney(new Money(30, Currency.USD));

        System.out.println(andrzej);
        System.out.println(kazimierz);

        andrzej.giveMoneyToPerson(new Money(33.33, Currency.PLN), kazimierz);

        System.out.println(andrzej);
        System.out.println(kazimierz);

        kazimierz.giveMoneyToPerson(new Money(14, Currency.USD), andrzej);
        System.out.println(andrzej);
        System.out.println(kazimierz);

        kazimierz.giveMoneyToPerson(new Money(24, Currency.USD), andrzej);
        System.out.println(andrzej);
        System.out.println(kazimierz);

        kazimierz.addItem(new Item("car"));
        kazimierz.addItem(new Item("teddy-bear"));

        System.out.println(kazimierz);

        kazimierz.addItemToSell(new Item("teddy-bear"), new Money(12, Currency.PLN));

        andrzej.buy(kazimierz, new Item("teddy-bear"));

        System.out.println(kazimierz);
        System.out.println(andrzej);
    }
}
