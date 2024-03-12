package com.sh.random;

import java.util.Random;

/**
 * <pre>
 *  java.util.Random클래스
 *  - 난수를 타입별로 생성하는 메소드 제공
 *  - Random#nextInt(int):int   경우의 수, 최소 값을 이용해 특정범위의 난수 생성
 *  - Random#nextDouble():double
 *  - Random#nextBoolean():boolean
 *      #은 non-static method라는 의미
 *  - Random#nextInt 난수 생성 공식 : Random#nextInt(경우의 수)+최소값
 *
 *</pre>
 */
public class App {
    public static void main(String[] args) {
        Random rnd = new Random();
        // 0~9
        System.out.println(rnd.nextInt(10)+0);
        //1~10
        System.out.println(rnd.nextInt(10)+1);
        //-128~127
        System.out.println(rnd.nextInt(256)-128);
        //double형 실수
        //0.0~1.0
        System.out.println(rnd.nextDouble());
        System.out.println(rnd.nextBoolean());

    }
}

