package com.sgg.api.string;

public class StringProcess {
    public String preChar(String s) {
        String str;
        str = s.toUpperCase().charAt(0) + s.substring(1);
        return str;
    }

    public int charSu(String s, char ch) {
        int num =0 ;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i) == ch){
                num++;
            }
        }
        return num;
    }
}
