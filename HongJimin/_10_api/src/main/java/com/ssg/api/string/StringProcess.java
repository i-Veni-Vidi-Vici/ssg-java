package com.ssg.api.string;

public class StringProcess {

    public String preChar(String s) {
        char[] chars = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            chars[i] = s.charAt(i);
        }
        s.toUpperCase(); //s
        return s;
    }

    public int charSu(String s, char ch) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ch) {
                count ++;
            }
        }
        return count;

    }
}
