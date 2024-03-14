package com.ssg.test1;

import java.util.Random;

public class RandomNumGenerator {
    public void generate() {
        // 1에서 1000사이의 정수범위의 난수를 생성
        Random rnd = new Random();
        int num = rnd.nextInt(1, 1001);
        // 난수출력, 생성된 난수가 300에서 600 사이에 포함되는지 여부 출력
        System.out.println(num);
        System.out.println(num >= 300 && num <= 600 ? "포함한다." : "포함하지 않는다.");
    }
}
