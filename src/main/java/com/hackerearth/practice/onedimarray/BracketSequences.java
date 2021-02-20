package com.hackerearth.practice.onedimarray;

import java.util.Scanner;

public class BracketSequences {

    public static void main(String...args) {
        // https://www.hackerearth.com/practice/data-structures/arrays/1-d/practice-problems/algorithm/bracket-sequence-1-40eab940/

        Scanner s = new Scanner(System.in);
        String line = s.nextLine();
        int parts = 0;
        if (line.length() % 2 == 0 && line.replace("(", "").length() == line.replace(")", "").length()) {
//            line = withStringReplces(line);
            line = withSteps(line);
            parts = countParts(line);
        }
        System.out.println(parts);
    }

    public static String withStringReplces(String line) {
        int l = 0, r = 0;
        int li = 0, ri = line.length() - 1;
        int side = 0;

        for (int i = 0; i < line.length(); i++) {
            if (side >= 0) {
                l += line.charAt(li) == '(' ? 1 : -1;
                li++;
            } else {
                r += line.charAt(ri) == '(' ? 1 : -1;
                ri--;
            }
            side = l + r;
        }

        line = line.substring(li) + line.substring(0, li);

        return line;
    }

    public static String withSteps(String line) {
        String removed = line;
        int size;

        do {
            size = removed.length();
            removed = removed.replace("()", "");
        } while (size != removed.length());

        if (removed.length() > 0) {
            removed = removed.replace("(", "");
            size = 0;
            for (int i = 0; i < line.length(); i++) {
                size += line.charAt(i) == ')' ? 1 : -1;
                if (size == removed.length()) {
                    size = i + 1;
                    break;
                }
            }
            line = line.substring(size) + line.substring(0, size);
        }

        return line;
    }

    public static int countParts(String line) {
        int opened = 0;
        int parts = 0;

        for (char s : line.toCharArray()) {
            opened += s == '(' ? 1 : -1;
            if (opened == 0) {
                parts++;
            }
        }

        return parts;
    }

}
