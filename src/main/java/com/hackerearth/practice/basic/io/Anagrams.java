package com.hackerearth.practice.basic.io;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Anagrams {

    // https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/anagrams-651/

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);

        int t = Integer.parseInt(scanner.nextLine());
        int n = 0;

        while (t-- > 0) {
            String as = scanner.nextLine();
            String bs = scanner.nextLine();

            n = (as + bs).chars().parallel().map(c -> (char) c).distinct().map(c -> {
                String r = String.format("[^%c]+", c);
                return Math.abs(as.replaceAll(r, "").length() - bs.replaceAll(r, "").length());
            }).reduce(0, Integer::sum);

            System.out.println(n);
        }
    }

}
