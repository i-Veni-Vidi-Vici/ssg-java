package com.ssg.test1;

public class RandomNumGenerator {
    public void generate() {
        int num = (int)(Math.random() * 1000) + 1;

        String result = (num >= 300 && num <= 600) ? "포함" : "미포함";
        System.out.println(num + "은 " + result + "됩니다.");
    }
}
