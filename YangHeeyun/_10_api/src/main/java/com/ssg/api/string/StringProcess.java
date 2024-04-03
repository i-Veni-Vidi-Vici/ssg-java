package com.ssg.api.string;

import static java.lang.Character.toUpperCase;

public class StringProcess {
    public String preChar(String s){
        char upper = s.toUpperCase().charAt(0);
        return upper + s.substring(1);
    }

    public int charSu(String s, char ch){
        int cnt = 0;
        for(int i=0;i<s.length();i++){
            if(ch == s.charAt(i))
                cnt++;
            }
        return cnt;
    }
}