package com.ssg.api.token;

import java.util.StringTokenizer;

public class TokenTest {
    public static void main(String[] args) {
        String str = "J a v a P r o g r a m ";
        StringTokenizer st = new StringTokenizer(str);
        int length = st.countTokens();
        System.out.println(length);
        char[] charSeq = new char[length];
        for(int i =0; i< length; i++){
            charSeq[i] = st.nextToken().charAt(0);
        }
        for(int i =0; i< charSeq.length; i++){
            System.out.print(charSeq[i]);
        }
        System.out.println();
        System.out.println((new String(charSeq)).toUpperCase());

    }
}
