package com.ssg.test1;

import java.util.Random;

public class RandomNumGenerator {
    public void genarate() {

        Random rnd = new Random();

        // 난수생성
        int answer = rnd.nextInt(1, 1001);
        // 난수출력
        System.out.println(answer);
        // 난수가 범위에 포함되었는지 출력
        System.out.println((answer >= 300 && answer <= 600) ? "포함됩니다." : "포함되지 않습니다.");
    }


}
