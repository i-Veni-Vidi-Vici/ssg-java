package com.ssg.oop.mehtod._static;

import java.util.Arrays;
import java.util.SimpleTimeZone;

public class StaticMethod {
    public static String toUpper(String str)
    {
        return str.toUpperCase();
    }

    public static String setChar(String str, int num, char ch)
    {
        //전달 받은 문자열을 number째 있는 문자를 ch로 바꿔라
        char[] temp=new char[str.length()];
        for(int i=0;i<str.length();i++)
        {
            if(i==num)
            {
                temp[i]+= ch;
            }
            else
                temp[i] += str.charAt(i);
        }
        return String.valueOf(temp);
    }

    //전달 받은 문자열에서 영문자 개수를 리턴
    public static int getAlphabetLenght(String str)
    {
        int cnt=0;
        for (int i=0;i<str.length();i++)
        {
            if((str.charAt(i)>='a'&&str.charAt(i)<='z')||
                    str.charAt(i)>='A'&&str.charAt(i)<='Z')
                cnt++;
        }
        return cnt;
    }

    //전달받은 문자열값을 하나로 합쳐서 리턴
    public static String concat(String str1,String str2)
    {
        return str1+str2;
    }
}
