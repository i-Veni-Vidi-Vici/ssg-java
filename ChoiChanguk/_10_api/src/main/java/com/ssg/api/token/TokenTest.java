package com.ssg.api.token;

import java.util.Arrays;
import java.util.StringTokenizer;

public class TokenTest {
    public static void main(String[] args) {
        String str="J a v a P r o g r a m ";

        StringTokenizer stringTokenizer=new StringTokenizer(str," ");
        String[] arr=stringTokenizer.nextToken().split(" ");

        int len=stringTokenizer.countTokens();
        char[] ch=new char[len];
        int cnt=0;
        StringBuilder sb=new StringBuilder();

        //1. char[]저장
        while (stringTokenizer.hasMoreElements()) {
            ch[cnt]=stringTokenizer.nextToken().charAt(0);
            sb.append(ch[cnt]);
            cnt++;
        }
        //2. 토큰 처리전 글자 및 개수 출력
        System.out.println(Arrays.toString(arr));
        //처리 후 문자 배열 개수
        //System.out.println("cnt);

        System.out.println(stringTokenizer.countTokens());
        for(int i=0;i<cnt;i++)
        {
            System.out.print(ch[i]);
        }

    }
}
