package com.ssg.test2;

import java.util.Random;

/**
 * 문제 2 : 기능제공 클래스
 *
 */
public class RandomUtils {
    public static void generate() {
//        1. 정수 범위의 난수를 생성
        Random rnd = new Random();
        int intRandom = Math.abs(rnd.nextInt());
        // 2. 난수출력, 홀수인지 짝수인지 출력
        System.out.println(intRandom);
        System.out.println(intRandom % 2 != 0 ? "홀수" : "짝수" );






    }
}
