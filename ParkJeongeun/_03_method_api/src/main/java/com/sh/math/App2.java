package com.sh.math;

/**
 * <pre>
 * 난수 생성하기
 * - Math.random():double // (리턴 타입이 double 이라는 의미)
 * - 0.0 이상 1.0 미만의 실수 반환
 * - 특정 범위의 난수 생성 공식 : (int) (Math.random() * 경우의 수) + 최소값
 *
 * </pre>
 */

public class App2 {
    public static void main(String[] args) {
        // 0 ~ 9 사이의 난수 생성
        System.out.println((int)(Math.random() * 10));
//        System.out.println((int)(Math.random()) * 10); // 괄호주의 - 모두 0 나옴

        // 1 ~ 10 사이의 난수 생성
        System.out.println((int) (Math.random() * 10) + 1);

        // 3 ~ 5 사이의 난수 생성
        System.out.println((int) (Math.random() * 3) + 3);

        // 10 ~ 15 사이의 난수 생성
        System.out.println((int) (Math.random() * 6) + 10);

        // -128 ~ 127 사이의 난수 생성
        // -128~0 : 129개, 1~127 : 127개 -> 256개
        System.out.println((int) (Math.random() * 256) - 128);
    }
}
