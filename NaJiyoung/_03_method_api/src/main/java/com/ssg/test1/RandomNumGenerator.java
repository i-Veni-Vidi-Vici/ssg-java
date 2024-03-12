package com.ssg.test1;

import java.util.Random;

public class RandomNumGenerator {
    public void generate() {
        Random rnd = new Random();
        int rndNum = rnd.nextInt(1000) + 1; // 1~1000 사이의 정수 범위의 난수 생성
        boolean isIncluded = (rndNum>=300 && rndNum<=600);  // 난수가 300~600 사이 포함되면 true

        System.out.println("난수 출력: " + rndNum + ", 난수가 300에서 600 사이에 포함되는지 여부: " + (isIncluded==true ? "포함된다" : "포함되지 않는다"));
    }
}
