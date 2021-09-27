package com.hackerearth.codemonk.arraysandstrings;

import java.util.*;
import java.util.function.Consumer;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import static java.util.Arrays.*;

public class CyclicShift {

    public static void main(String...args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.valueOf(scanner.nextLine());

        String original, line;
        String[] linearr;
        int n, k, i, shift = 0;
        int max, maxCount, maxSum;
        boolean cycle;
        int[] ints;

        Pattern pattern = Pattern.compile("(1+0+)");

        while (t-- > 0) {

            linearr = scanner.nextLine().split(" ");
            n = Integer.parseInt(linearr[0]);
            k = Integer.parseInt(linearr[1]);

            var a = new ArrayList<Integer>();
            a.removeIf((Integer b) -> b > 0);

            original = scanner.nextLine();
            line = original;

            if (line.contains("1") && line.contains("0")) {

                if (line.charAt(0) == '1' && line.charAt(0) == line.charAt(line.length() - 1)) {
                    shift = line.indexOf("0");
                    line = line.substring(shift) + line.substring(0, shift);
                }

                if (line.charAt(0) == '0') {
                    i = line.indexOf("1");
                    shift += i;
                    line = line.substring(i) + line.substring(0, i);
                }

                ints = pattern.matcher(line).results().map(MatchResult::group).mapToInt(s -> Integer.parseInt(s, 2)).toArray();

                max = ints[0];
                maxCount = 0;
                maxSum = ints[0];
                cycle = false;

                for (i = 1; i < ints.length;) {
                    if (ints[i] > max) {
                        
                    }
                }


            } else {

            }
        }
    }
}
