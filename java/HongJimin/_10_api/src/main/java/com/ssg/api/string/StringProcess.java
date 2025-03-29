package com.ssg.api.string;

public class StringProcess {

    public String preChar(String s) {
//        char[] chars = new char[s.length()];
//        for (int i = 0; i < s.length(); i++) {
//            chars[i] = s.charAt(i);
//        }
        return s.substring(0, 1).toUpperCase() + s.substring(1);
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
