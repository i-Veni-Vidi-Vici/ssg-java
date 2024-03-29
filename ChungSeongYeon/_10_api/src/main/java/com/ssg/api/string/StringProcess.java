package com.ssg.api.string;

public class StringProcess {
    public String preChar(String s){
        return s.replace(s.charAt(0), s.toUpperCase().charAt(0));
    }

    public int charSu(String s, char ch){
        int cnt = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ch)
                cnt++;
        }
        return cnt;
    }
}
