package com.sh.method.random;

import java.util.Random;

/**
 * java.util.Random클래스
 * - 난수를 타입별로 생성하는 메소드 제공
 * - Random#nextInt(Int) : int반환 -> 경우의 수 , 최소값을 이용해 특정범위의 난수를 생성
 * - Random#nextDouble(): double
 * - Random#nextBoolean() : boolean
 *  - #이 들어가면 non - static 메소드라는 뜻
 * -Random#nextInt 난수 생성 공식 : Random#nextInt(경우의 수 )  + 최소값
 */

public class App {
    public static void main(String[] args) {
        Random rnd = new Random();
        // 0 - 9
        System.out.println(rnd.nextInt(10) + 0);
        // 1- 10
        System.out.println(rnd.nextInt(10) + 1);
        // -128 ~ 127
        System.out.println(rnd.nextInt(256) -127);

        //double형 실수
        System.out.println(rnd.nextDouble()); //Math.random()과 동일 0.0 - 1.0
        //booelan형 논리값
        System.out.println(rnd.nextBoolean());


    }
}
