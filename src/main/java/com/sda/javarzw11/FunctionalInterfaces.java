package com.sda.javarzw11;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.UnaryOperator;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        interfaceExample();
        streamExample();
    }

    private static void interfaceExample() {
        List<String> texts = Arrays.asList("a", "b", "c", "ab", "ac", "bc", "abaca");

        texts.replaceAll((s) -> s.replace("a", "d") + "z");

        System.out.println(texts);
    }


    private static void streamExample() {
        List<String> texts = Arrays.asList("a", "b", "c", "ab", "ac", "bc", "abaca");

        texts.parallelStream()
                .map(s -> s + "z")
                .filter(s -> s.length()>2)
                .map(String::length)
                .map(i -> i*i)
                .filter(i -> i<10)
                .findAny().ifPresent(i -> System.out.println(i));

    }
}
