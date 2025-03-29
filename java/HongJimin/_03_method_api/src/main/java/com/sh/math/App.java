package com.sh.math;

public class App {
    public static void main(String[] args) {
        //1. 절댓값
        System.out.println(Math.abs(-7)); //int
        System.out.println(Math.abs(7)); //int
        System.out.println(Math.abs(-9.5)); //double
        System.out.println("");

        //2. 최대/최솟값
        System.out.println(Math.max(10, 20));
        System.out.println(Math.max(20, 10));
        System.out.println(Math.min(20, 10));
        System.out.println(Math.min(10, 20));

        //3. 난수 생성 : 0.0이상 ~1.0 미만의 난수(double 반환)
        System.out.println(Math.random());

        //4. Math관련 상수 제공
        System.out.println(Math.PI);


    }
}
