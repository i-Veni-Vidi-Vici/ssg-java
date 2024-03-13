package com.ssg.test1;

public class RandomNumGenerator {
    public void generate() {
        int rnd = ((int) (Math.random() * 1000) + 1);
        System.out.println("난수 출력: " + rnd);
        System.out.println("난수가 300 ~ 600 사이인가? " + ((rnd >= 300 && rnd <= 600) ? "네" : "아니요"));
    }

}
