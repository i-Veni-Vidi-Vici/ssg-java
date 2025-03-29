package com.sh.random;

import java.util.Random;

/**
 * <pre>
 * java.util.Random 클래스
 * # = non-static method라는 뜻이다
 * - 난수를 타입별로 생성하는 메소드 제공
 * - Random#nextInt(int):int // int를 받고 int를 반환, 경우의 수, 최소값을 이용해 특정범위의 난수 생성
 * - Random#newxtDouble():double
 * - Random#nextBoolean():boolean
 *
 * -- RandomnextInt 난수생성 공식 : Random#nextInt(경의수) + 최소값
 * </pre>
 */
public class App {
    public static void main(String[] args)
    {
        Random rnd = new Random();
        //0~9
        System.out.println("0~9 난수 : " + rnd.nextInt(10));

        //1~10
        System.out.println("1~10 난수 :"+ (rnd.nextInt(10) + 1));

        //-128 ~ 127
        System.out.println(rnd.nextInt(256) - 128);

        //double형 실수
        System.out.println(rnd.nextDouble());

        //double형 실수
        System.out.println(rnd.nextBoolean());
    }
}
