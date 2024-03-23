package com.ssg.oop.method._static;

public class StaticMethod {

    public static String toUpper(String academy) {
        return academy.toUpperCase();
    }

    public static String setChar(String java, int j, char x)
    {
        char[] ch =java.toCharArray();
        ch[j] = x;
        return String.valueOf(ch);



    }

    public static int getAlphabetLength(String s) {
        int count =0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)>='a'&&s.charAt(i)<='z'||s.charAt(i)>='A'&&s.charAt(i)<='Z')
            {
                count++;
            }
        }
        return count;
    }

    public static String concat(String hello, String world) {
        return hello+world;
    }
}
