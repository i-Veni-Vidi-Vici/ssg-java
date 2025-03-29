package com.sh.math;

/**
 * <pre>
 * 난수 생성하기
 * - Math.random():double
 * - 0.0이상 ~ 1.0미만의 실수를 반환
 * - 특정 범위의 난수 생성 공식 : (int) (Math.random() * 경우의 수) + 최소값
 *
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        // 0 ~ 9 사이의 난수 생성
        System.out.println((int) (Math.random() * 10)); // 0.0 ~ 1.0 -> 0.0 ~ 10.0
//        System.out.println((int)(Math.random()) * 10);  // 형변환 주의 : 모두 0이 나온다.

        // 1 ~ 10 사이의 난수 생성
        System.out.println((int) (Math.random() * 10) + 1); // (int)(Math.random()*10+1) -> 이것도 10 나옴

        // 3 ~ 5 사이의 난수 생성
        System.out.println("3 ~ 5 : " + (int) (Math.random() * 3) + 3);

        // 10 ~ 15 사이의 난수 생성
        System.out.println("10 ~ 15 : " + (int) (Math.random() * 6) + 10);

        // -128 ~ 127 사이의 난수 생성
        System.out.println("-128 ~ 127 : " + (int) (Math.random() * 256) + -128);
    }
}
