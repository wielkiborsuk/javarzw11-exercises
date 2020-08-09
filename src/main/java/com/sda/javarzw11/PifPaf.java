package com.sda.javarzw11;

import java.util.Random;
import java.util.Scanner;

public class PifPaf {

    static int pifDiv = 3;
    static int pafDiv = 7;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int limit = scanner.nextInt();

        for (int i=1; i<=limit; i++) {
            if (i % pifDiv == 0 || i % pafDiv == 0) {
                System.out.println(replaceNumber(i));
            } else {
                System.out.println(i);
            }
        }
    }

    private static String replaceNumber(int number) {
        String result = "";
        if (number % pifDiv == 0) {
            result += "Pif";
        }

        if (number % pafDiv == 0) {
            if (!result.isEmpty()) {
                result += " ";
            }
            result += "Paf";
        }

        return result;
    }
}
