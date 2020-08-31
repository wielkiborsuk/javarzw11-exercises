package com.sda.javarzw11.moneyhandler;

public interface MoneyHandler {

    void setQuantity(int quantity);
    void setNext(MoneyHandler next);
    boolean execute(int amount);
}
