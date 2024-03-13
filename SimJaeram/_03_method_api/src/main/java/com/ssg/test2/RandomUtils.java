package com.ssg.test2;

import java.util.Random;
public class RandomUtils {
    public static void generate() {
        // 1. 정수 범위의 난수를 생성
        Random rd = new Random();
        int num = rd.nextInt();

        // 2. 난수출력, 홀수인지 짝수인지 출력
        String isOdd = ((Math.abs(num) % 2) == 1) ? "홀수" : "짝수";
        System.out.println("난수: " + num + ", 생성된 난수는 " + isOdd + "입니다.");

    }
}
