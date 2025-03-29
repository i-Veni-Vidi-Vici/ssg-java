package com.ssg.test1;

import java.util.Random;

public class RandomNumGenerator {
    public void generate()
    {
        Random rnd = new Random();
        int num = rnd.nextInt(1000) + 1;
        if(num>300&&num<600)
        {
            System.out.println("300~600 사이입니다.");
        }
        else
            System.out.println("300~600 사이가 아닙니다.");

    }
}
