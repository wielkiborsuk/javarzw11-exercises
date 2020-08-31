package com.sda.javarzw11.moneyhandler;

public abstract class AbstractMoneyHandler implements MoneyHandler {

    private int quantity;
    private MoneyHandler next;

    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public void setNext(MoneyHandler next) {
        this.next = next;
    }

    @Override
    public boolean execute(int amount) {
        System.out.println(this.getClass().getName());
        System.out.println(String.format("amount %d quantity %d VALUE %d", amount, quantity, getValue()));
        if (quantity * getValue() >= amount) {
            return true;
        } else if (next != null) {
            int rest = amount - quantity * getValue();
            return next.execute(rest);
        } else {
            return false;
        }
    }

    public abstract int getValue();
}
