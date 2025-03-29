package com.ssg.test2;

import java.util.Random;

public class RandomUtils {
    public static void generate() {
        Random rnd = new Random();
        // 정수 범위의 난수를 생성
        int answer = rnd.nextInt();
        // 난수 출력
        System.out.println(answer);
        // 홀수인지 짝수인지 출력
        System.out.println(answer % 2 == 0 ? "짝수입니다" : "홀수입니다" );

    }
}
