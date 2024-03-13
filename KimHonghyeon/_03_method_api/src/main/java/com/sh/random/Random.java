package com.sh.random;

/**
 * java.util.Random 클래스
 * - 난수를 타입별로 생성하는 메소드 제공
 * - Random#nextInt(int): int  경우의수, 최소값을 이용해 특정범위의 난수 생성
 * - Random#nextDouble():double
 * - #은 인스턴스 메소드를 나타냄
 */

public class Random {
    public static void main(String[] args) {
        java.util.Random rnd = new java.util.Random();
        //0~9
        System.out.println(rnd.nextInt(10)+0);
        //1~10
        System.out.println(rnd.nextInt(10)+1);
        // -128~127
        System.out.println(rnd.nextInt(256)-128);

        //double형
        System.out.println(rnd.nextDouble());
        //boolean형
        System.out.println(rnd.nextBoolean());


    }
}
