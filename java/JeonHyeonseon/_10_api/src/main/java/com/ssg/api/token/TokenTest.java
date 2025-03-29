package com.ssg.api.token;

import java.util.StringTokenizer;

public class TokenTest {
    public static void main(String[] args) {

        String str = "J a v a p r o g r a m";
        // Token처리하여 char[]에 저장
        char[] chToken;
        // 토큰 처리전 글자 및 개수 출력
        System.out.println("토큰 처리 전 글자 : " + str);
        System.out.println("토큰 처리 전 개수 : " + str.length());

        // 토큰 처리 후 문자배열 갯수 출력 확인
        StringTokenizer tokenizer = new StringTokenizer(str, "/");
        System.out.println();

    }
}
