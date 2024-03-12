package com.sh.math;

/**
 * <pre>
 *     난수 생성하기
 *     - Math.random(): double
 *     - 0.0 이상 ~ 1.0 미만의 실수를 반환
 *     - 특정 범위의 난수 생성 공식 : (int) (Math.random() * 경우의 수) + 최소값
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        // 0 ~ 9 까지의 난수 생성
        // (int) Math.random() * 10은 0만 나온다. (int) Math.random()이 먼저 연산되기 때문에
        // 형변환 주의
//        System.out.println((int) (Math.random() * 10));

        // 1 ~ 10 사이의 난수 생성
        System.out.println("1 ~ 10 : " + (int) (Math.random() * 10) + 1);

        // 3 ~ 5 사이의 난수 생성
        System.out.println("3 ~ 5 : " + ((int) (Math.random() * 3) + 3));

        // 10 ~ 15 사이의 난수 생성
        System.out.println("10 ~ 15 : " + ((int) (Math.random() * 6) + 10));

        // -128 ~ 127 사이의 난수 생성
        System.out.println("-128 ~ 127 : " + ((int) (Math.random() * 257) - 128));
    }
}
