package com.ssg.test2;

import java.util.Random;

public class RandomUtils {
    public static void generate() {
        Random rnd = new Random();
        int rndNum = rnd.nextInt(); // 정수 범위의 난수 생성
        boolean isOddEven = ((rndNum % 2) == 1);    // 난수가 홀수면 true, 짝수면 false

        System.out.println("난수 : " + rndNum + ", 홀수인지 짝수인지?: " + (isOddEven == true ? "홀수" : "짝수"));
    }
}
