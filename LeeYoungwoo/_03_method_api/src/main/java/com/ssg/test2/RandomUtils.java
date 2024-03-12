package com.ssg.test2;

import java.util.Random;

public class RandomUtils {
    public void generate() {
        Random rnd = new Random();
        int answer = rnd.nextInt();
        System.out.println(answer);

    }
}
