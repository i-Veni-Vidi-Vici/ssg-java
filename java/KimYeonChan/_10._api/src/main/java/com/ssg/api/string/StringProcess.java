package com.ssg.api.string;

public class StringProcess {
    public String preChar(String s) {
        return s.replace(s.charAt(0), s.toUpperCase().charAt(0));
    }

    public int charSu(String s, char ch) {
        return s.length() - s.replace(String.valueOf(ch), "").length();
    }
}
