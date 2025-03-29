package com.sh.random;

import java.util.Random;

/**
 * java.util.Random 클래스
 * - Random#nextInt():int 경우의 수, 최소값을 이용해 특정범위의 난수 생성
 * - Random#nextDouble():double
 * - Random#nextBoolean():boolean
 * Random#nextInt 난수생성 공식: Random#nextInt(경우의 수) + 최솟값
 */
public class App {
    public static void main(String[] args) {
        Random rnd = new Random();
        // 0~9 사이의 난수
        System.out.println(rnd.nextInt(10));
        // 1~10 사이의 난수
        System.out.println(rnd.nextInt(10) + 1);

        // -128~127
        System.out.println(rnd.nextInt(256) - 128);

        // double 형 실수
        System.out.println(rnd.nextDouble());
        // boolean 형 논리값
        System.out.println(rnd.nextBoolean());

    }
}
