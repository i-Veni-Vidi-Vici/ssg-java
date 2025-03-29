package com.ssg.api.token;

import java.util.Arrays;
import java.util.StringTokenizer;

public class TokenTest {
    public static void main(String[] args) {
        //1
        String str = "J a v a P r o g r a m ";
        StringTokenizer st = new StringTokenizer(str, " ");
        char[] result = new char[st.countTokens()];
        int index =0;

        //2
        System.out.println("토큰 처리전 글자 및 개수"+ str + st.countTokens());

        while (st.hasMoreTokens()) {
            result[index++] = st.nextToken().charAt(0);
        }
        // 3
        System.out.println("토큰 처리후 개수:"+st.countTokens());
        System.out.println("문자배열 갯수"+result.length);

        //4
        System.out.println(Arrays.toString(result));

        // 5
        System.out.println(String.valueOf(result).toUpperCase());
    }
}
