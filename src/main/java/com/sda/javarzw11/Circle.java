package com.sda.javarzw11;

import java.util.Scanner;

public class Circle {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        float diameter = input.nextFloat();

        double circuference = Math.PI * diameter;

        System.out.println(circuference);
    }
}
