package com.ssg.test2;

import java.util.Random;

public class RandomUtils {
    public static void generate(){
        Random rnd = new Random();
        int randomInt=rnd.nextInt();
        System.out.println("난수는 = "+randomInt);
        System.out.println(randomInt%2==0?"짝수입니다":"홀수입니다");
    }
}
