package com.ssg.oop.method._static;

public class StaticMethod {
    public static String toUpper(String str) {
        String changeStr = "";
        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i) >= 65 && str.charAt(i) <= 90) || (str.charAt(i) >= 97 && str.charAt(i) <= 122)) {
                changeStr += (char)(str.charAt(i) - 32);
            } else {
                changeStr += str.charAt(i);
            }
        }
        return changeStr;
    }

    public static String setChar(String str, int index, char word) {
        String changeStr = "";
        for (int i = 0; i < str.length(); i++) {
            if (i == index) {
                changeStr += word;
            } else {
                changeStr += str.charAt(i);
            }
        }
        return changeStr;
    }

    public static int getAlphabetLength(String str) {
        int alphabetNums = 0;
        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i) >= 65 && str.charAt(i) <= 90) || (str.charAt(i) >= 97 && str.charAt(i) <= 122)) {
                alphabetNums++;
            }
        }
        return alphabetNums;
    }

    public static String concat(String str1, String str2) {
        return str1 + str2;
    }
}
