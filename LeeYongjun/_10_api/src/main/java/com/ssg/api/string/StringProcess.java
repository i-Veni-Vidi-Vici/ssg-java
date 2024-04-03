package com.ssg.api.string;

public class StringProcess {

    public String preChar(String helloWorld) {
        String str = "helloworld";
        str = str.substring(0, 1).toUpperCase() + str.substring(1);
        return str;
    }

    public int charSu(String s, char ch) {
        int count = 0;
        s = "application car cable";
        ch = 'c';

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ch) {
                count++;
            }
        }
        return count;
    }
}
