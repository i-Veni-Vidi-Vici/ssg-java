package com.ssg.test1;

import java.util.Random;

public class RandomNumGenerator {
    public void generate()
    {
        Random rnd = new Random();
        int number = rnd.nextInt(1000) + 1;

        System.out.println("숫자 : " + number);
        if(number >= 300 && number <=600) System.out.println("숫자가 300~600 사이에 있음!");
        else System.out.println("숫자가 300~600 사이에 없음.");

    }



}
