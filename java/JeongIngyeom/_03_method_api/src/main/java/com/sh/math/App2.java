package com.sh.math;

/**
 * <pre>
 * 난수 생성하기
 * - Math.random():double
 * - 0.0 이상 ~ 1.0 미만의 실수를 반환
 * - 특정 범위의 난수 생성 공식 : (int) (Math.random() * 경우의 수) + 최소값
 *
 * </pre>
 */
public class App2 {

    public static void main(String[] args) {
        // 0 ~ 9 사이의 난수 생성
        System.out.println((int) (Math.random() * 10));
        System.out.println((int) (Math.random()) * 10);     // 형변환 주의 : 항상 0이 나온다.

        // 1 ~ 10 사이의 난수 생성
        System.out.println((int) (Math.random() * 10) + 1);

        // 3 ~ 5 사이의 난수 생성
        System.out.println((int) (Math.random() * 3) + 3);      // 0.0 ~ 2.xx -> 0 ~ 2 -> 3 ~ 5

        // 10 ~ 15 사이의 난수 생성
        System.out.println((int) (Math.random() * 6) + 10);

        // -128 ~ 127 사이의 난수 생성
        System.out.println((int) (Math.random() * 256) - 128);

    }
}
