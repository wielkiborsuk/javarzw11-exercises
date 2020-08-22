package com.sda.javarzw11.money;

public class Main {

    public static void main(String[] args) {
        Person andrzej = new Person("Andrzej");
        Person kazimierz = new Person("Kazimierz");
        System.out.println(andrzej);
        System.out.println(kazimierz);

        andrzej.receiveMoney(new Money(10));
        kazimierz.receiveMoney(new Money(40));

        System.out.println(andrzej);
        System.out.println(kazimierz);

        andrzej.giveMoneyToPerson(new Money(33.33), kazimierz);

        System.out.println(andrzej);
        System.out.println(kazimierz);
    }
}
