package com.ssg.api.token;

import java.util.Arrays;
import java.util.StringTokenizer;

public class TokenTest {
    public static void main(String[] args) {
        String str1 = "J a v a P r o g r a m";
        String tmpstr = "";
        //공백문자를 구분자로 사용
        StringTokenizer tokenizer = new StringTokenizer(str1 , " ");
        //토큰 처리 전 글자 및 개수 출력
        //토큰 처리 후 문자배열 갯수 출력
        System.out.println("토큰 처리 전 문자열");
        System.out.println(str1);
        System.out.println("문자 개수 : "+str1.length());

        int t = 0;
        char[] chs = new char [tokenizer.countTokens()];
        while(tokenizer.hasMoreTokens()){
             chs[t++] = tokenizer.nextToken().charAt(0);
        }
        System.out.println("토큰 처리 후 문자배열 갯수 : "+ chs.length);
        System.out.println("--토큰 처리후 문자 배열 출력---");
        System.out.println(Arrays.toString(chs));
        String str2 =String.valueOf(chs);
        System.out.println(str2.toUpperCase());
    }

}
