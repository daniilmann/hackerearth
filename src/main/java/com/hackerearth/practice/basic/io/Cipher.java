package com.hackerearth.practice.basic.io;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cipher {

    // https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/cipher-1/

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        int k = Integer.parseInt(scanner.nextLine());

        Map<Character, Character> map = new HashMap<>();
        IntStream.range('a', (int)'z' + 1).forEach(c -> map.put((char)c, (char)((c - 'a' + k) % 26 + 'a')));
        IntStream.range('A', (int)'Z' + 1).forEach(c -> map.put((char)c, (char)((c - 'A' + k) % 26 + 'A')));
        IntStream.range(0, 10).forEach(c -> map.put((char)(c + 48), (char)(((c + k) % 10) + '0')));

        System.out.println(s.chars().parallel().mapToObj(c -> (char)c).map(c -> map.getOrDefault(c, c)).map(String::valueOf).collect(Collectors.joining("")));
    }
}
