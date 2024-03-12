package com.ssg.test2;

public class RandomUtils {
    public static void generate() {
        int num = ((int)(Math.random() * (Integer.MAX_VALUE - Integer.MIN_VALUE + 1)) + Integer.MIN_VALUE);
        System.out.println(num);
        System.out.println(num % 2 == 0 ? "짝수" : "홀수");
    }
}
