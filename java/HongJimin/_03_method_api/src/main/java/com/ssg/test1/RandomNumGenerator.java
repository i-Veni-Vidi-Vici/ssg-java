package com.ssg.test1;

import java.util.Random;

public class RandomNumGenerator {
    public void generate() {
        //1에서 1000사이의 정수 범위의 난수를 생성
        Random rdn = new Random();
        int createdrdn = rdn.nextInt(1, 1001);

        //난수출력, 생성된 난수가 300에서 600사이에 포함되는지 여부 출력
        System.out.println("난수는 " + createdrdn + "입니다.");
        System.out.println("생성된 난수는 300 ~ 600 사이에 " + (
                createdrdn >= 300 && createdrdn <= 600 ?
                        "포함됩니다!" : "포함되지 않습니다ㅜㅡㅜ"
                ));
    }
}
