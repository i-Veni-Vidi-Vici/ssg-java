package com.ssg.test2;

import java.util.Random;

public class RandomUtils {
    public static void generate() {
        Random rnd = new Random();
        //정수범위의 난수생성
        int num = rnd.nextInt();
        System.out.println(num);
        if (num % 2 == 0) {
            System.out.println("짝수");
        }else System.out.println("홀수");
    }
}
