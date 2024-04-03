package com.sgg.test2;

import java.util.Random;

public class RandomUtils {

    public static void generate(){
        Random random = new Random();

        int ranNum = random.nextInt();

        if (ranNum%2 == 0){
            System.out.println(ranNum);
            System.out.println("짝수 입니다.");
        }
        else {
            System.out.println(ranNum);
            System.out.println("홀수 입니다.");
        }
    }
}
