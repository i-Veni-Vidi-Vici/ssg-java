package com.ssg.oop.mehtod._static;

public class StaticMethod {
    public static String toUpper(String str)
    {
        String str1;
        return str.toUpperCase();
    }

    public static String setChar(String str, int num, char ch)
    {
        //전달 받은 문자열을 number째 있는 문자를 ch로 바꿔라
        for(int i=0;i<str.length();i++)
        {
            //str+i=num;
        }
        return str;
    }

    //전달 받은 문자열에서 영문자 개수를 리턴
    public static int getAlphabetLenght(String str)
    {
        int cnt=0;
        return cnt;
    }

    //전달받은 문자열값을 하나로 합쳐서 리턴
    public static String concat(String str1,String str2)
    {
        String sumStr;
        sumStr=str1.concat(str2);
        return sumStr;
    }
}
