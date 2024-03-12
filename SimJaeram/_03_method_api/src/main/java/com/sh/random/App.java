package com.sh.random;

import java.util.Random;

/**
 * <pre>
 *     java.util.Random 클래스
 *     - 난수를 타입별로 생성하는 메소드 제공
 *     - Random#nextInt(int):int        // 경우의수와 최솟값을 이용해 특정범위의 난수 생성, Random 클래스의 nextInt() 메소드는 int를 리턴
 *     - Random#nextDouble():double     // #은 non-static 메소드라느 뜻
 *     - Random#nextBoolean():boolean
 *     
 *     - Random#nextInt 난수 생성 공식 : Random#nextInt(경우의 수) + 최솟값
 * </pre>
 */

public class App {
    public static void main(String[] args) {
        Random rnd = new Random();

        // 0 ~ 9
        System.out.println(rnd.nextInt(10) + 0);

        // 1 ~ 10
        System.out.println(rnd.nextInt(10) + 1);

        // -128 ~ 127
        System.out.println(rnd.nextInt(256) -128);

        // double형 실수
        System.out.println(rnd.nextDouble());               // Math.random()과 동일 (0.0 이상 1.0 미만)

        // boolean형 논리값
        System.out.println(rnd.nextBoolean());              // true or false
    }

}
