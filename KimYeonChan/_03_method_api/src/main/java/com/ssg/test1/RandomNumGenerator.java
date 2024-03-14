package com.ssg.test1;

import java.util.Random;

public class RandomNumGenerator {
    public void generate() {
        Random rnd = new Random();
        int rndNum = rnd.nextInt(1000) + 1;
        System.out.println(rndNum);
        if (rndNum >= 300 && rndNum <= 600) {
            System.out.println("난수는 300에서 600사이에 포함됩니다.");
        }
    }
}
