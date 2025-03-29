package com.sh.math;

public class App {
    public static void main(String[] args) {
        // 1. 절대값
        System.out.println(Math.abs(-7));

        // 2. 최대 / 최소값
        System.out.println(Math.max(10, 20));
        System.out.println(Math.min(10, 20));

        // 3. 난수 생성 : 0.0 이상 ~ 1.0 미만의 난수(double) 반환
        System.out.println(Math.random());

        // 4. Math 관련 상수 제공
        System.out.println(Math.PI);
    }
}
