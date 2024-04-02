package com.ssg.api.string;

import java.util.Scanner;

public class StringProcess
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringProcess stringProcess = new StringProcess();
        System.out.println("문자열 입력 : ");
        String str = sc.next();
        String answer = stringProcess.preChar(str);
        System.out.println(answer);

        int num = stringProcess.charSu("aaplication car cable",'c');
        System.out.println(num);
    }

    public String preChar(String s){
        String string = s.replace(s.charAt(0), (char) (s.charAt(0) - 32));
        return string;
    }

    public int charSu(String s, char ch)
    {
        int cnt = 0;
        for(int i = 0; i< s.length(); i++)
        {
            if(s.charAt(i) == ch) cnt ++;
        }

        return cnt;
    }
}
