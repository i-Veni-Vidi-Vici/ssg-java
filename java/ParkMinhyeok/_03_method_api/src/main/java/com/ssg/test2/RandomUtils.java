package com.ssg.test2;

import java.util.Random;

public class RandomUtils {
    public static void generate() {
        Random rnd = new Random();
        int num = rnd.nextInt();
        boolean isEven = num % 2 == 0;
        System.out.println(isEven ? "짝수" : "홀수");
    }
}
