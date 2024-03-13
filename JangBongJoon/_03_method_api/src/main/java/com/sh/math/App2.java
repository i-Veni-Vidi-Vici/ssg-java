package com.sh.math;


/*
난수생성하기
Math.random():double
특정범위의 난수 생성공식:(int) (Math.random() * 범위) + 최소값
 */
public class App2 {
    public static void main(String[] args) {
        // 0~9사이의 난수생성
        System.out.println((int) (Math.random() * 10)); // 0.0~1.0 -> 0.0 ~10.0
        System.out.println((int) (Math.random() * 10) + 1); // 1.0 ~ 10.0
        //3~5 사이의 난수 생성
        System.out.println((int) (Math.random() * 3) + 3);


    }
}
