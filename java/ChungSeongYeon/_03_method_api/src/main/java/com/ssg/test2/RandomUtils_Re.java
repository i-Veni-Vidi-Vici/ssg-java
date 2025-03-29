package com.ssg.test2;

import java.util.Random;

public class RandomUtils_Re {
    public static void generate() {
        Random random = new Random();
        int num = random.nextInt(); // int 정수범위안에서 난수 하나 반환
        boolean isEven = num % 2 == 0;
        System.out.println(num + "은 " + (isEven ? "짝수" : "홀수"));
                
    }
}
