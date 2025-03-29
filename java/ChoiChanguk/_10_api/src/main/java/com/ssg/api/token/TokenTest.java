package com.ssg.api.token;

import java.util.Arrays;
import java.util.Locale;
import java.util.StringTokenizer;

public class TokenTest {
    public static void main(String[] args) {
        String str="J a v a P r o g r a m ";
        StringTokenizer stringTokenizer=new StringTokenizer(str," ");

        int len=stringTokenizer.countTokens();
        char[] ch=new char[len];
        String strTemp="";
        int cnt=0;
        StringBuilder sb=new StringBuilder();

        //토큰 처리전
        System.out.println("문자열 : "+str+"개수 출력 : "+str.length());
            //1. char[]저장
        while (stringTokenizer.hasMoreElements()) {
            ch[cnt]=stringTokenizer.nextToken().charAt(0);
            cnt++;
        }

        //3. 처리 후 문자 배열 개수
        System.out.println("문자 배열 개수 : "+cnt);

        //4. char[] 값 출력
        System.out.print("char[] : ");
        for(int i=0;i<cnt;i++)
        {
            System.out.print(ch[i]);
        }

        //5. char[] -> String -> upper
        for(int i=0;i<cnt;i++)
        {
            strTemp+=ch[i];
        }
        System.out.println("\n문자열 : "+strTemp.toUpperCase());

    }
}
