package com.sda.javarzw11;

import java.util.*;
import java.util.stream.Collectors;

public class RandomNumbersUnique {
    static int listSize = 100;
    static int randomLimit = 50;
    static Random random = new Random();

    public static void main(String[] args) {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i=0; i<listSize; i++) {
            randomNumbers.add(random.nextInt(randomLimit));
        }

        System.out.println(randomNumbers);

        iterativeSolution(randomNumbers);
        collectionsSolution(randomNumbers);
        predicateSolution(randomNumbers);
    }

    private static void iterativeSolution(List<Integer> randoms) {
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();
        for (Integer r : randoms) {
            if (seen.contains(r)) {
                duplicates.add(r);
            } else {
                seen.add(r);
            }
        }

        System.out.println(duplicates);

        Set<Integer> uniques = new HashSet<>();

        for (Integer r : randoms) {
            if (!duplicates.contains(r)) {
                uniques.add(r);
            }
        }

        System.out.println(uniques);
    }

    private static void collectionsSolution(List<Integer> randomsOrig) {
        List<Integer> randoms = new ArrayList<>(randomsOrig);
        Set<Integer> allNumbers = new HashSet<>(randoms);

        List<Integer> duplicatesList = new ArrayList<>(randomsOrig);
        for (Integer number : allNumbers) {
            duplicatesList.remove(number);
        }
        Set<Integer> duplicates = new HashSet<>(duplicatesList);

        Set<Integer> uniques = new HashSet<>(allNumbers);
        uniques.removeAll(duplicates);

        System.out.println(duplicates);
        System.out.println(uniques);
    }

    private static void predicateSolution(List<Integer> randoms) {
        Set<Integer> duplicate = randoms.stream()
                .filter(r -> Collections.frequency(randoms, r) > 1)
                .collect(Collectors.toSet());

        Set<Integer> uniques = randoms.stream()
                .filter(r -> Collections.frequency(randoms, r) == 1)
                .collect(Collectors.toSet());

        System.out.println(duplicate);
        System.out.println(uniques);
    }
}
