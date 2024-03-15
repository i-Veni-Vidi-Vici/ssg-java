package com.ssg.test1;

import java.util.Random;

public class RandomNumGenerator {
    public void generate() {
        int num = (int) (Math.random() * 1000) + 1;

        String result = (num >= 300 && num <= 600) ? "포함" : "비포함";
        System.out.println(num + "은" + result + "됩니다.");
    }
}
