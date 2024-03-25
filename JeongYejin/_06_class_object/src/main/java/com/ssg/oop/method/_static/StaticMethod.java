package com.ssg.oop.method._static;

public class StaticMethod {
    public static String toUpper(String str) {
        String changed = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                changed += (char)(str.charAt(i)-32);
            } else  {
                changed += ' ';
            }
        }
        return changed;
    }

    public static String setChar(String str, int index, char c) {
        String changed = "";
        for (int i = 0; i < str.length(); i++) {
            if (i == index) {
                changed += c;
            } else {
                changed += str.charAt(i);
            }
        }
        return changed;
    }

    public static int getAlphabetLength(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 65 && str.charAt(i)<=90 || str.charAt(i) >= 97 && str.charAt(i) <= 122) {
                sum += 1;
            }
        }
        return sum;
    }

    public static String concat(String str1, String str2) {
        String changed = str1 + str2;
        return changed;
    }
}
