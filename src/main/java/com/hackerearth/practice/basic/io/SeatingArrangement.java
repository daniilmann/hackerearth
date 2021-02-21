package com.hackerearth.practice.basic.io;

import java.util.Scanner;

public class SeatingArrangement {

    // https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/seating-arrangement-1/

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());

        int seat = 0;
        int facing = 0;
        int side = 0;
        int comp = 0;
        String type = null;
        while (t-- > 0) {
            seat = Integer.parseInt(scanner.nextLine());
            comp = seat % 12;
            facing = (seat / 12 - (comp == 0 ? 1 : 0)) * 12 + (12 - (seat - 1) % 12);
            side = seat % 6;
            if (side == 0 || side == 1) {
                type = "WS";
            } else if (side == 2 || side == 5) {
                type = "MS";
            } else {
                type = "AS";
            }
            System.out.println(String.format("%s %s", facing, type));
        }
    }
}