package com.ssg.test1;

import java.util.Random;

/** 1. 정수 범위의 난수를 생성
 *  2. 난수출력, 홀수인지 짝수인지 출력
 *
 */
public class RandomUtils {
    public static void generate(){
        Random rnd = new Random();
        int tmp = rnd.nextInt();
        System.out.println("생성된 난수는: "+tmp+"입니다");
        if(tmp%2 == 1){
            System.out.println("홀수 입니다");
        }else{
            System.out.println("짝수 입니다");
        }

    }
}
