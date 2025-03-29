package com.ssg.test1;

import java.util.Random;

public class RandomNumGenerator {
    public void generate(){
        Random random = new Random();
        int number = random.nextInt(1000) + 1;

        System.out.println(number);
        if(number>=300 && number <=600)
            System.out.println("포함");
        else System.out.println("미포함");
    }
}
