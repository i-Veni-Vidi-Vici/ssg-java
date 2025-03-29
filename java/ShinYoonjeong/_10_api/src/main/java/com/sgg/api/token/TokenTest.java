package com.sgg.api.token;

import java.util.Arrays;
import java.util.StringTokenizer;

public class TokenTest {
    public static void main(String[] args) {
        String data = "J a v a P r o g r a m ";
        String[] arr = data.split(" ");
        char[] ch = new char[arr.length];
        int i=0;

        StringTokenizer tokenizer = new StringTokenizer(data, " ");

        while (tokenizer.hasMoreElements()) {
            String token = tokenizer.nextToken();
            System.out.println("token = " + token + ", 남은 토큰수 = " + tokenizer.countTokens());
            char[] tokenCh = token.toCharArray();
            System.arraycopy(tokenCh, 0, ch, i, tokenCh.length);
            i+=tokenCh.length;

        }
        System.out.println(Arrays.toString(ch).toUpperCase());

    }
}
