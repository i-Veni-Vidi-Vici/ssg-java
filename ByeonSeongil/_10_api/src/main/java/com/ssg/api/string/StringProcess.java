package com.ssg.api.string;

public class StringProcess {
    public String preChar(String s) {
        return s.replaceFirst(s.substring(0,1), s.substring(0,1).toUpperCase());
    }

    public int charSu(String s, char ch) {
        char[] charArray = s.toCharArray();
        int count =0;

        for (char c : charArray) {
            if (c == ch) {
                count++;
            }
        }

        return count;
    }
}
