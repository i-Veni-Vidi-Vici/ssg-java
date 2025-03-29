package com.ssg.test2;

import java.util.Random;

public class RandomUtils {

    public static void generate() {
        Random random = new Random();
        int randomNum = random.nextInt();
        boolean isEven = isEven(randomNum);
        printResult(randomNum, isEven);
    }

    private static boolean isEven(int num) {
        return num % 2 == 0;
    }

    private static void printResult(int num, boolean isEven) {
        System.out.println("난수 " + num + "가 짝수인가? 홀수인가? : " + (isEven ? "짝수" : "홀수"));
    }
}
