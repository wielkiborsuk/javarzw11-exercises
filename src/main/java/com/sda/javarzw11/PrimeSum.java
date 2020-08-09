package com.sda.javarzw11;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class PrimeSum {

    public static boolean isPrime(int number) {
        return number > 1
                && IntStream.rangeClosed(2, (int) Math.sqrt(number))
                .noneMatch(n -> (number % n == 0));
    }

    public static void main(String[] args) {
        plainJavaSolution();
        ultraStreamSolution();
        halfStreamSolution();
    }

    private static void plainJavaSolution() {
        int suma = 0;
        for (int i=201; i<1200; i++) {
            if (isPrime(i) && i % 10 == 3) {
                suma += i * i;
            }
        }

        System.out.println(suma);
    }

    private static void ultraStreamSolution() {
        int sum = IntStream.rangeClosed(200, 1200)
                .filter(PrimeSum::isPrime)
                .filter(i -> i % 10 == 3)
                .map(i -> i * i)
                .sum();

        System.out.println(sum);
    }


    private static void halfStreamSolution() {
        List<Integer> numbers = new ArrayList<>();
        for(int i=200; i<1200; i++) {
            numbers.add(i);
        }

        Integer sum = numbers.stream()
                .filter(PrimeSum::isPrime)
                .filter(i -> i % 10 == 3)
                .map(i -> i * i)
                .reduce(0, (a, b) -> a + b);

        System.out.println(sum);
    }
}
