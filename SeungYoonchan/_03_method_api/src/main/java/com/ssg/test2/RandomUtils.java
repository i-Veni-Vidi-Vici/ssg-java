package com.ssg.test2;

import java.util.Random;

public class RandomUtils {
    public static void generate(){
        Random rnd = new Random();
        int num = rnd.nextInt(1000) + 1;

        System.out.println(num);
        System.out.println("난수는 " + (num / 2 == 0 ? "짝수" : "홀수") + " 입니다.");
    }
}
