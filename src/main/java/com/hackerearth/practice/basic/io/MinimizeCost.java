package com.hackerearth.practice.basic.io;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class MinimizeCost {

    // https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/minimise-cost-89b54cb9/

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);

        String[] nk = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);

        int[] a = Arrays.stream(scanner.nextLine().split(" ")).parallel().mapToInt(Integer::parseInt).toArray();

        int[] b = new int[a.length];
        System.arraycopy(a, 0, b, 0, a.length);
        int[] t = new int[b.length];


        int ln = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] <= 0) {
                continue;
            }
            int v = a[i];
            int last = Math.min(i + k, a.length - 1);
            int d;
            int j = Math.max(i - k, ln);
            for (; j <= last && v > 0; j++) {
                if (b[j] < 0 && i != j) {
                    d = Math.max(b[j], -v);
                    v += d;
                    b[j] = b[j] - d;
                    t[j] = t[j] - d;
                }
            }
            ln = j - 1;
            t[i] = -b[i] + v;
            b[i] = v;
        }

        long sum = IntStream.range(0, a.length).parallel().boxed().map(i -> Math.abs((long) a[i] + t[i])).reduce(0L, Long::sum);

        System.out.println(sum);
    }
}
