package com.ssg.api.token;

import java.util.Arrays;

public class TokenTest {
    public static void main(String[] args) {
        String str = "J a v a P r o g r a m ";
        char[] chToken;
        System.out.println("토큰 처리 전 글자 : " + str);
        System.out.println("토큰 처리 전 개수 : " + str.length());

        String[] splitStr = str.split(" ");
        chToken = new char[splitStr.length];
        System.out.println("토큰 처리 후 문자배열 갯수 : " + splitStr.length);
        for(int i = 0; i < splitStr.length; i++) {
            chToken[i] = splitStr[i].charAt(0);
        }
        System.out.println("char[] 값 : " + Arrays.toString(chToken));

        System.out.println("대문자로 변환하여 출력한 String 결과 : " + new String(chToken).toUpperCase());
    }
}
