package com.hackerearth.practice.basic.io;

import java.util.Scanner;

public class CostOfBallons {

    // https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/mojtaba-prepares-contest-29b2a044/

    public static void main(String...args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());

        String[] stringPrice = null;
        int green = 0, purple = 0;
        int users = 0;
        String[] contests = null;
        int[] sum = new int[2];
        while (t-- > 0) {
            stringPrice = scanner.nextLine().split(" ");
            green = Integer.parseInt(stringPrice[0]);
            purple = Integer.parseInt(stringPrice[1]);

            if (green < purple) {
                green = green - purple;
                purple = green + purple;
                green = purple - green;
            }

            users = Integer.parseInt(scanner.nextLine());
            sum[0] = 0;
            sum[1] = 0;
            while (users-- > 0) {
                contests = scanner.nextLine().split(" ");
                sum[0] += Integer.parseInt(contests[0]);
                sum[1] += Integer.parseInt(contests[1]);
            }
            System.out.println(sum[0] > sum[1] ? sum[0] * purple + sum[1] * green : sum[0] * green + sum[1] * purple);
        }
    }

}
