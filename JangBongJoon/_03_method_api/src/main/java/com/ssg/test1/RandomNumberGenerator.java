package com.ssg.test1;

import java.util.Random;

public class RandomNumberGenerator {
    //1~ 1000사이의 난수 생성
    public void generate() {
        Random rnd = new Random();
        int number = rnd.nextInt(1000) + 1;
        System.out.println(number);
        if (number >= 300 && number <= 600) {
            System.out.println("300과 600사이에 있음");
        }
        else System.out.println("300과 600사이에 없음");
    }

    public void generateV2(int number) {
        Random rnd = new Random();
        boolean isRndin = true;


    }

}
