package com.ssg.test2;

import java.util.Random;

public class RandomUtils {
    public static void generate() {
        // 정수 범위의 난수를 생성
        Random rnd = new Random();
        int num = rnd.nextInt(1000) + 1;
        // 난수출력, 홀수인지 짝수인지 출력
        System.out.println(num);
        System.out.println(num / 2 == 0  ? "짝수" : "홀수");
    }
}
