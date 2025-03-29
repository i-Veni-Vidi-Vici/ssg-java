package com.ssg.api.token;

import java.util.Arrays;
import java.util.StringTokenizer;

public class TokenTest {
    public static void main(String[] args) {
        String str1 = "J a v a P r o g r a m";
        System.out.println(str1);
        System.out.println(str1.length());

        StringTokenizer tokenizer = new StringTokenizer(str1, " ");
        char[] chars = new char[tokenizer.countTokens()];
        // 토큰 char[]에 저장
        System.out.println(chars.length);
        for (int i = 0; i < chars.length; i++) {
            chars[i] = tokenizer.nextToken().charAt(0);
        }
        System.out.println(Arrays.toString(chars));
        // char[] 다시 String 으로 변환
        String str2 = "";
        for (char aChar : chars) {
            str2 += (aChar);
        }
        // 대문자로 변환
        System.out.println(str2.toUpperCase());
    }
}
