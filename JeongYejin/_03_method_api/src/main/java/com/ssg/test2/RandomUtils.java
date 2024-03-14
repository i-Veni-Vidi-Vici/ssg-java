package com.ssg.test2;

import java.util.Random;

public class RandomUtils {
    public static void generate() {
        int num = ((int)(Math.random() * (Integer.MAX_VALUE - Integer.MIN_VALUE + 1)) + Integer.MIN_VALUE);
        Random rnd = new Random();
        num = rnd.nextInt();
        boolean  isEven = num % 2 == 0;
        System.out.println(num);
//        System.out.println(num % 2 == 0 ? "짝수" : "홀수");
        System.out.println(isEven ? "짝수" : "홀수");
    }
}
