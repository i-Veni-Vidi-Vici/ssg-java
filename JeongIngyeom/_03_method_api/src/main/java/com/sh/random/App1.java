package com.sh.random;

import java.sql.SQLOutput;
import java.util.Random;

/**
 * <pre>
 * java.util.Random 클래스
 * - 난수를 타입별로 생성하는 메소드를 제공
 * - Random#nextInt(int) : int  경우의수, 최소값을 이용해 특정 범위의 난수 생성
 * - Random#nextDouble(double) : double
 * - Random#nextBoolean(boolean) : boolean
 *
 * - Random#nextInt 난수 생성 공식 : Random#nextInt(경우의 수) + 최소값
 *
 * 위의 #들은 non-static 메소드라는 의미이다!
 * </pre>
 */
public class App1 {

    public static void main(String[] args) {
        Random rnd = new Random();
        // 0 ~ 9
        System.out.println(rnd.nextInt(10));

        // 1 ~ 10
        System.out.println(rnd.nextInt(10) + 1);

        // -128 ~ 127
        System.out.println(rnd.nextInt(256) - 128);

        // double형 실수
        System.out.println(rnd.nextDouble());       // Math.random()과 동일 (0.0 이상 ~ 1.0 미만)

        // boolean형 논리값
        System.out.println(rnd.nextBoolean());


    }
}
