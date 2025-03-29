package com.ssg.api.string;

import java.util.StringTokenizer;

public class StringProcess {
    public String preChar(String s) {
        String preChar = String.valueOf(s.charAt(0));
        s = s.replace(String.valueOf(s.charAt(0)), preChar.toUpperCase());
        return s;
    }

    public int charSu(String s, char ch) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ch)
                count++;
        }
        return count;
    }
}
