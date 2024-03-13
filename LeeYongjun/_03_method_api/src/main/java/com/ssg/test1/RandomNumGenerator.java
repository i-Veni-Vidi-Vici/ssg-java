package com.ssg.test1;
import com.ssg.test1.App1;

import java.util.Random;

public class RandomNumGenerator {
    public void generate() {
        Random rnd = new Random();
        int nansoo = rnd.nextInt(1000) + 1;
        System.out.println("생성된 난수 : " + nansoo);
        if (300 <= nansoo && nansoo <= 600) {
            System.out.println(" 300~  600사이의 숫자입니다");
        } else {
            System.out.println(" 300 ~ 600사이의 숫자가 아닙니다");
        }
    }
}
