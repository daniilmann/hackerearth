package com.hackerearth.practice.basic.io;

import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SplitHouses {

    // https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/split-house-547be0e9/

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);

        scanner.nextLine();
        String line = scanner.nextLine();

        if (line.contains("HH")) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
            System.out.println(line.replace(".", "B"));
        }
    }
}
