package com.sh.math;

/**
 * <pre>
 * 난수 생성하기
 * - Math.random():double
 * - 0.0 이상 ~ 1.0 미만의 실수를 반환
 * - 특정범위의 난수 생성 공식 : (int) (Math.random() * 경우의 수) + 최솟값
 * </pre>
 */

public class App2 {
    public static void main(String[] args) {
        // 0 ~ 9 사이의 난수 생성
        System.out.println((int)(Math.random() * 10));
//        System.out.println((int)(Math.random()) * 10); // 잘못된 예

        // 1 ~ 10 사이의 난수 생성 (10-1+1)
        System.out.println("1 ~ 10 : " + ((int)(Math.random() * 10) + 1));

        // 3 ~ 5 사이의 난수 생성 (5-3+1)
        System.out.println("3 ~ 5 : " + ((int)(Math.random()*3) + 3));

        // 10 ~ 15 사이의 난수 생성 (15-10+1)
        System.out.println("10 ~ 15 : " + ((int)(Math.random()*6) + 10));

        // -128 ~ 127 사이의 난수 생성 (127-(-128)+1)
        System.out.println("-128 ~ 127 : " + ((int)(Math.random()*256) - 128));
    }
}

