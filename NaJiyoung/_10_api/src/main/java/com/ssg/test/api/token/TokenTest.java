package com.ssg.test.api.token;

import java.util.Arrays;
import java.util.StringTokenizer;

public class TokenTest {
    public static void main(String[] args) {
        String s = "J a v a P r o g r a m ";

        // 2번
        System.out.println("토큰 처리 전)");
        System.out.println(s);
        System.out.println("개수: " + s.length());
        System.out.println();


        // 1번
        System.out.println("토큰 처리 후)");
        String[] sarr = s.split(" ");
        char[] chars = new char[sarr.length];

        for(int i=0; i< chars.length; i++) {
            chars[i] = sarr[i].charAt(0);
        }
        System.out.println(Arrays.toString(chars));

//        StringTokenizer tokenizer1 = new StringTokenizer(str, " ");
//        while (tokenizer1.hasMoreTokens()) {
//            String token = tokenizer1.nextToken();
//            chars = new char[token.length()];
//
//            for(int i=0; i< token.length(); i++) {
//                chars[i] = token.charAt(i);
//                System.out.print(chars[i]);
//            }
//        }
//        System.out.println();

        // 3번
        System.out.println("개수: " + sarr.length);

        // 4번
        System.out.println(chars);

        // 5번
        System.out.println(new String(chars).toUpperCase());
    }
}
