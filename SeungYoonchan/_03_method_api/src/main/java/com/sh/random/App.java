package com.sh.random;

import java.util.Random;

/**
 * <h3>java.util.Random 클래스</h3>
 * <pre>
 *     - 난수를 타입별로 생성하는 메소드 제공
 *     - 경우의 수, 최소값을 이용해 특정 범위의 난수 생성
 *     - Random#nextInt(int)  : int
 *     - Random#nextDouble()  : double
 *     - Random#nextBoolean() : boolean
 *
 *     -Random#nextInt 난수 생성 공식 : Random#nextInt(경우의수) + 최소값
 * </pre>
 */
public class App {
    public static void main(String[] args){
        Random rnd = new Random();
        // 1 ~ 10
        System.out.println(rnd.nextInt(10) + 1);
        System.out.println(rnd.nextInt(10) + 1);
        System.out.println(rnd.nextInt(10) + 1);
        System.out.println();
        // -128 ~ 127
        System.out.println(rnd.nextInt(258) - 128);
        System.out.println();

        // double형 실수
        System.out.println(rnd.nextDouble()); // Math.random()과 동일 (0.0 ~ 1.0)
        System.out.println();
        // boolean형 논리값
        System.out.println(rnd.nextBoolean());
        System.out.println();



    }
}
