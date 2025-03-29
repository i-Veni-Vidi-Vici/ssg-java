package com.ssg.test2;

import java.util.Random;

public class RandomIUtils {
    public static void generate(){
        Random rnd = new Random();
        int randomNum = rnd.nextInt();

        System.out.println(randomNum%2==0?randomNum + "은 짝수": randomNum + "은 홀수");

        // boolean isEven = num%2==0;
        //System.out.println(num +"은 " + (isEven ?)"짝수":"홀수");

    }
}
