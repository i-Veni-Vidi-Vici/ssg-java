package com.ssg.oop.method._static;

import java.awt.*;

public class StaticMethod {

    public String toUpper(String upper) {
        return upper.toUpperCase();
    }

    public String setChar(String str, int index, char newchar){
        char[] chars = str.toCharArray();
        chars[index] = newchar;
        return new String(chars);
    }
    public int getLength(String getlength){
        int count = 0;
        for (int i = 0; i < getlength.length(); i++) {
            char ch = getlength.charAt(i);
            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                count++; // 영문자면 개수 증가
            }
        }
        return count;
    }

    public String Concat(String str1 , String str2){
        return str1 + str2;
    }
}
