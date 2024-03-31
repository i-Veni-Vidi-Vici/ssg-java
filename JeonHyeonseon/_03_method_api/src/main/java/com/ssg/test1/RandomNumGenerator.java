package com.ssg.test1;

import java.util.Random;

public class RandomNumGenerator {
    /**
     * 1. 1에서 1000사이의 정수범위의 난수를 생성
     * 2. 난수출력, 생성된 난수가 300에서 600사이에 포함되는지 여부 출력
     */
    public void generate() {
        int num = (int)((Math.random()*1000) + 1); // 난수 생성
        System.out.println(num);
        System.out.println(num >= 300 && num <= 600 ? "포함한다" : "포함하지 않는다");
    }
}
