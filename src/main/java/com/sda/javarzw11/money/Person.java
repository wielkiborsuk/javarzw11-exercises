package com.sda.javarzw11.money;

import com.sda.javarzw11.money.exceptions.ItemNotFoundException;
import com.sda.javarzw11.money.exceptions.NotEnoughMoneyException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Person {

    String name;
    Wallet wallet;

    List<Item> backpack = new ArrayList<>();
    Map<Item, Money> toSell = new HashMap<>();

    public Person(String name) {
        this.name = name;
        wallet = new Wallet();
    }

    public void addItem(Item newItem) {
        this.backpack.add(newItem);
    }

    public void addItemToSell(Item newItem, Money value) {
        this.toSell.put(newItem, value);
    }

    public Money doISellThis(Item item) {
        if (this.toSell.containsKey(item)) {
            return this.toSell.get(item);
        }
        return null;
    }

    public void buy(Person other, Item item) {
        Money price = other.doISellThis(item);

        if (price != null) {
            try {
                other.takeItem(item);
                wallet.takeOutMoney(price);
                other.receiveMoney(price);
                addItem(item);
            } catch (ItemNotFoundException e) {
                System.out.println("Counldn't sell the item, item missing.");
            } catch (NotEnoughMoneyException e) {
                System.out.println("Couldn't buy, not enough money, giving back the item.");
                other.addItem(item);
            }
        }
    }

    public void takeItem(Item item) throws ItemNotFoundException {
        if (!this.backpack.remove(item)) {
            throw new ItemNotFoundException();
        }
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
        return String.format("Person {name=%s, %s, backpack=%s}", name, wallet, backpack);
    }
}
