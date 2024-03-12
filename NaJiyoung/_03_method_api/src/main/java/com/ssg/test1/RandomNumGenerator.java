package com.ssg.test1;

public class RandomNumGenerator {
    public void generate() {
        int rndNum = (int) ((Math.random() * 1000) + 1);
        boolean isIncluded = rndNum>=300 && rndNum<=600;
        System.out.println("난수 출력: " + rndNum + ", 난수가 300에서 600 사이에 포함되는지 여부: " + (isIncluded==true ? "포함된다" : "포함되지 않는다"));
    }
}
