package com.ssg.oop.method._static;

import java.util.Locale;

public class StaticMethod {
    private String str;
    private String str2;
    private int num;
    private char ch;

    public StaticMethod(){

    }
    public StaticMethod(String str1) {
        this.str = str;
    }
    public StaticMethod(String str,int num,char ch)
    {
        this.str = str;
        this.num = num;
        this.ch = ch ;
    }

    public StaticMethod(String str, String str2)
    {
        this.str = str;
        this.str2 = str2;
    }

    public static String toUpper(String str)
    {
       String string = str.toUpperCase();
        return  string;
    }

    public static String setChar(String str, int number, char ch)
    {
        char[] ch2 = str.toCharArray();
        for(int i = 0; i<ch2.length; i++)
        {
            if(i == number)
            {
                if (ch2[i] == ch2[number]) {
                    ch2[i] = ch;
                }
            }
        }
        return new String(ch2);
    }

    public static int getAlphabetLength(String str){
        char ch;
        int count = 0;
        for(int i = 0; i<str.length(); i++)
        {
            //65 - 90 97-122
            ch = str.charAt(i);
            if((ch >= 65 && ch<=90) || (ch>=97 && ch <= 122)) count ++;
        }
        return count;
    }

    public static String concat(String str1, String str2){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str1).append(str2);
        String string = stringBuilder.toString();
        return string;

    }

}
