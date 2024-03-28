package com.ssg.api.token;

import java.util.Arrays;

public class Practice {
    public static void main(String[] args) {
        char[] hungry = new char[6];
        hungry[0] = 'h';
        hungry[1] = 'u';
        hungry[2] = 'n';
        hungry[3] = 'g';
        hungry[4] = 'r';
        hungry[5] = 'y';

        System.out.println(hungry);
        System.out.println(Arrays.toString(hungry).toUpperCase());
        System.out.println(new String(hungry).toUpperCase());

        String s = "what the fuck";
        String[] arr = s.split("[ ]");
        System.out.println(Arrays.toString(arr));
    }
}