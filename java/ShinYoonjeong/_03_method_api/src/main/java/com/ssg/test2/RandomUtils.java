package com.ssg.test2;

import java.util.Random;

public class RandomUtils {
    public static void generate() {
        Random rnd = new Random();
        int num = rnd.nextInt();
        if(num%2==0)
        {
            System.out.println("짝수입니다.");
        }
        else
            System.out.println("홀수입니다.");

    }

}
