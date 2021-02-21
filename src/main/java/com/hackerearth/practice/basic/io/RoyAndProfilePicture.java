package com.hackerearth.practice.basic.io;

import java.util.Scanner;

public class RoyAndProfilePicture {

    // https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/roy-and-profile-picture/

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);

        int l = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());

        String[] whs;
        int[] wh = new int[2];

        while (n-- > 0) {
            whs = scanner.nextLine().split(" ");
            wh[0] = Integer.parseInt(whs[0], 10);
            wh[1] = Integer.parseInt(whs[1], 10);
            if (wh[0] < l || wh[1] < l) {
                System.out.println("UPLOAD ANOTHER");
            } else if (wh[0] != wh[1] && (wh[0] > l || wh[1] > l)) {
                System.out.println("CROP IT");
            } else {
                System.out.println("ACCEPTED");
            }
        }
    }

}
