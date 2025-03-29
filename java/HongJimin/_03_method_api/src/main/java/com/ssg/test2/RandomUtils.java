package com.ssg.test2;

import java.util.Random;

public class RandomUtils {
    public static void generate() {
        //1. 정수 범위의 난수를 생성
        Random rdn = new Random();

        //2. 난수출력, 홀수인지 짝수인지 출력
        int createdrdn = rdn.nextInt();
        System.out.println("난수는 " + createdrdn + "입니다.");
        System.out.println("출력된 난수는 " + (
                createdrdn % 2 ==0 ?
                        "짝수입니다!" : "홀수입니다!"
                ));

    }

}
