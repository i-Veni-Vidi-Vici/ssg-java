package com.ssg.test1;

import java.util.Random;

public class RandomNumGenerator {
    public void generate(){
        Random rnd = new Random();
        int num = rnd.nextInt(1000) + 1;

        System.out.println("생성된 난수가 300~600 사이에 포함되는가? ");
        System.out.println(num);
        System.out.println((num >= 300 && num <= 600) ? "YES" : "NO");
    }
}
