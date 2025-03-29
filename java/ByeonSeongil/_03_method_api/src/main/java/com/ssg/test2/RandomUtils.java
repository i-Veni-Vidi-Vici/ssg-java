package com.ssg.test2;

import java.util.Random;

public class RandomUtils {
    public static void generate() {
        Random random = new Random();
        int number = random.nextInt();

        if (number % 2 == 1) {
            System.out.println("홀수");
        } else System.out.println("짝수");
    }
}
