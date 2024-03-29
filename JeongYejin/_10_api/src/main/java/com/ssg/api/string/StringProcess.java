package com.ssg.api.string;

public class StringProcess {
    public String preChar(String s) {
        char first = s.toUpperCase().charAt(0);
        String result = first + s.substring(1);
        return result;
    }


    public String preChar2(String s) {
        char sFirstUpper = s.toUpperCase().charAt(0);
//        return s.replace(s.charAt(0), sFirstUpper);
       return s.replace(s.charAt(0), s.toUpperCase().charAt(0));
    }

    public int charSu(String s, char ch) {
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (ch == s.charAt(i)){
                num++;
            }
        }
        return num;
    }
}