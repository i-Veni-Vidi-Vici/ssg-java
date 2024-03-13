package com.sh.math;

/**
 * <pre>
 * 난수 생성하기
 * - Math.random():double
 * - 0.0 이상 ~ 1.0 미만의 실수를 반환
 * - 특정범위의 난수 생성 공식 : (int) (Math.random() * 경우의수) + 최솟값
 *
 *
 * </pre>
 *
 */


public class App2 {
    public static void main(String[] args) {
        // 0 ~ 9사이의 난수 생성
        System.out.println((int) (Math.random() * 10)); // 0.0 ~ 1.0 -> 0.0 ~ 10.0
//        System.out.println((int) (Math.random()) * 10); // 형변환 주위 : 이러면 모두 0만 나옴!!

        // 1~10 사이의 난수 생성
        System.out.println((int)(Math.random() * 10) + 1); // 최소값이 1부터 시작이라 + 1

        System.out.println("--------------------");
        // 3~5 사이의 난수 생성
        System.out.println((int)(Math.random() * 3 ) + 3);

        // 10 ~ 15 사이의 난수 생성
        System.out.println((int)(Math.random() * 6) + 10);

        // -128 ~ 127 사이의 난수 생성
        System.out.println((int)(Math.random() * 256 -128));


    }
}
