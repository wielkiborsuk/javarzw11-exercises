package com.sda.javarzw11.packagesize;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();

        PackageSize packageSize = PackageSize.getPackageSize(size);

        System.out.println(packageSize);
    }
}
