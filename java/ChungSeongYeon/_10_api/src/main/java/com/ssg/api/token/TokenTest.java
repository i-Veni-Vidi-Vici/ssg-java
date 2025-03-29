package com.ssg.api.token;

import java.util.Arrays;

public class TokenTest {

    public static void main(String[] args) {
        String str = "J a v a P r o g r a m ";

        System.out.println(str); // 토큰 처리전 글자 출력

        System.out.println(str.length()); // 전 글자갯수 출력

        String[] sarr = str.split(" ");
        System.out.println(sarr.length); // 토큰 처리 후 글자갯수 출력

        char[] carr = new char[sarr.length];

        for (int i = 0; i < sarr.length; i++) {
            carr[i] = sarr[i].charAt(0);
        }

        System.out.println(Arrays.toString(carr));
        System.out.println(carr); //char[] 값 출력

        System.out.println(new String(carr).toUpperCase()); //char[] 을 다시 String 으로 바꾼 후 모두 대문자로 변환하여 출력

    }

}
