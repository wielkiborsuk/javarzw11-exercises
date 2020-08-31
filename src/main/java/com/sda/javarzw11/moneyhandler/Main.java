package com.sda.javarzw11.moneyhandler;

public class Main {

    public static void main(String[] args) {
        MoneyHandler ten = new TenMoneyHandler();
        MoneyHandler five = new FiveMoneyHandler();
        MoneyHandler two = new TwoMoneyHandler();
        MoneyHandler one = new OneMoneyHandler();

        ten.setQuantity(3);
        five.setQuantity(2);
        two.setQuantity(3);
        one.setQuantity(17);

        ten.setNext(five);
        five.setNext(two);
        two.setNext(one);

        if (ten.execute(47)) {
            System.out.println("enough");
        } else {
            System.out.println("you're poor");
        }
    }
}
