package com.ssg.test2;

import java.util.Random;

public class RandomUtils {
    public static void generate() {
        Random rnd = new Random();
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        int rndNum = rnd.nextInt() + min;

        System.out.println("난수 : " + rndNum);
//        System.out.println("난수가 범위 안에 있나? " + ((rndNum >= min && rndNum <= max) ? "맞다.": "아니다."));
        System.out.println("난수가 홀수인가 짝수인가? " + ((rndNum % 2 == 0) ? "짝수" : "홀수"));

    }
}
