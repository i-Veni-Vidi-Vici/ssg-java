package com.sh.math;

/**
 * <pre>
 * 난수 생성하기
 * - Math.random():double
 * - 0.0 이상 ~ 1.0 미만의 실수를 반환
 * - 특정 범위의 난수 생성 공식 : (int) (Math.random() * 경우의 수) + 최소값
 *
 * <pre/>
 */
public class App2 {
    public static void main(String[] args) {
        System.out.println((int) (Math.random() * 10) + 1);
        System.out.println((int) (Math.random() * 3) + 3);
        System.out.println((int) (Math.random() * 256) + (-128));
    }
}
