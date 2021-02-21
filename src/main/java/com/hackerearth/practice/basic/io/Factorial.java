package com.hackerearth.practice.basic.io;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Factorial {

    // https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/find-factorial/

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        System.out.println(n <= 2 ? n : IntStream.range(2, n + 1).parallel().reduce(1, (a, b) -> a * b));
    }
}
