package com.ssg.test2;

import java.util.Random;

public class RandomUtils {
    public void generate() {
        Random rnd = new Random();
        int rndNum = rnd.nextInt(1000) + 1;
        System.out.println(rndNum);
        if (rndNum % 2 == 0) {
            System.out.println("짝수다");
        }
        else {
            System.out.println("홀수다");
        }
    }
}
