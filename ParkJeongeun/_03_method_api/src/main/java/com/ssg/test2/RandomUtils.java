package com.ssg.test2;

public class RandomUtils {
    public static void generate() {
        int rnd = (int) (Math.random() * 1000) +1;
        System.out.println(rnd + "는 " + ((rnd % 2 == 0) ? "짝수" : "홀수"));
    }
}
