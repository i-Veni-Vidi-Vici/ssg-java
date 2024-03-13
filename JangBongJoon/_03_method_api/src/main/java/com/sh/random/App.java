package com.sh.random;


import java.util.Random;

/*

java.util.random클래스
난수를 타입별로 생성하는 메소드 제공
random #nextInt(int):int 경우의수, 최소값을 이용해 특정범위의 난수 생성
random#nextDouble():double
random#nextBoolean():boolean

Random#nextInt난수생성 공식: random#nextInt(경우의수) + 최소값
 */
public class App {
    public static void main(String[] args) {
        Random rnd = new Random();
        //0~9
        System.out.println(rnd.nextInt(10));
        //1~10
        System.out.println(rnd.nextInt(10) + 1);
        //-128 ~ 127
        System.out.println(rnd.nextInt(256) - 128);

        //double형 실수
        System.out.println(rnd.nextDouble());
        //boolean형 논리값
        System.out.println(rnd.nextBoolean());
    }
}
