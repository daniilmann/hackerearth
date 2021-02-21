package com.hackerearth.practice.basic.io;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberOfSteps {

    // https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/make-all-equal-90a21ab2/

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);

        scanner.nextLine();

        List<Integer> a = Arrays.asList(scanner.nextLine().split(" ")).parallelStream().map(Integer::valueOf).collect(Collectors.toList());
        List<Integer> b = Arrays.asList(scanner.nextLine().split(" ")).parallelStream().map(Integer::valueOf).collect(Collectors.toList());

        if (a.contains(0) && b.parallelStream().anyMatch(v -> v > 0)) {
            System.out.println(-1);
            return;
        }

        Set<Integer> x = IntStream.range(0, a.get(0) / b.get(0) + 1)
                .map(i -> a.get(0) - b.get(0) * i)
                .boxed().collect(Collectors.toCollection(ConcurrentSkipListSet::new));

        try {
            IntStream.range(1, a.size()).parallel().forEach(i -> {
                int t;
                if (b.get(i) == 0) {
                    t = a.get(i);
                    x.removeIf(v -> v != t);
                } else {
                    t = b.get(i);
                    int m = a.get(i) % b.get(i);
                    x.removeIf(v -> (v - m) % t != 0);
                }
                if (x.size() == 0) {
                    throw new IllegalStateException("Impossible");
                }
            });
            int s = x.stream().collect(Collectors.toMap(
                    k -> k,
                    m -> IntStream.range(0, a.size()).parallel().map(i -> (a.get(i) - m) / b.get(i)).sum()))
                    .values().stream().min(Integer::compareTo).get();
            System.out.println(s);
        } catch (Exception e) {
            System.out.println(-1);
        }
    }

}
