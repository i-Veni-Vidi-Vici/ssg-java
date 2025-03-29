package com.ssg.api.string;

import java.util.Locale;

public class StringProcess {
    public String preChar(String helloWorld) {
        char ch=helloWorld.toUpperCase().charAt(0);
        String temp=helloWorld.replace(helloWorld.charAt(0),ch);
        return temp;
    }

    public int charSu(String applicationCarCable, char c) {
        int cnt=0;
        for (int i=0;i<applicationCarCable.length();i++) {
            if(applicationCarCable.charAt(i)==c)
                cnt++;
        }
        return cnt;
    }
}
