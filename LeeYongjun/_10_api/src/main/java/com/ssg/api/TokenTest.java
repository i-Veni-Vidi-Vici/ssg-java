package com.ssg.api;

import java.util.Arrays;
import java.util.StringTokenizer;

public class TokenTest {
    public static void main(String[] args) {
        String str = "J a v a P r o g r a m ";

        StringTokenizer tokenizer = new StringTokenizer(str," ");
        char[] ch = new char[tokenizer.countTokens()];
        // 요구사항 1: 문자열을 공백 단위로 Token 처리하여 char[]에 저장하여 출력
        for (int i = 0; i < tokenizer.countTokens(); i++) {
            ch[i] = tokenizer.nextToken().charAt(0);
        }
        System.out.println(Arrays.toString(ch));

        System.out.println("토큰 처리 후 문자배열 갯수 : " + tokenizer.countTokens());
        System.out.println(ch);


        // 요구사항 2: 토큰 처리 전 글자 및 개수 출력
        System.out.println("토큰 처리 전 글자 및 개수");
        System.out.println(str);
        System.out.println("개수 : " + ch.length);
        System.out.println();

        System.out.println("char[] 값 출력:");

        // 요구사항 5: char[]을 다시 String으로 변환, 모두 대문자로 변환하여 출력
        System.out.println("\nchar[]을 다시 String으로 변환하여 대문자로 출력:");
        String upper = new String(ch).toUpperCase();
        System.out.println(upper);
    }
}
