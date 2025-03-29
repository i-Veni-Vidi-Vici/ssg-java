package com.sh.method.math;

/**
 * <pre>
 *   난수 생성하기
 *   - Math.random() : double
 *   - 0.0이상 ~ 1.0미만의 실수를 반환
 *   - 특정범위의 난수 생성 공식 : Math.random() * 경우의 수 + 최소값
 * </pre>
 */

public class App2 {
    public static void main(String[] args) {
        // 0~9사이

        //System.out.println((int) (Math.random() * 10));
        //System.out.println((int) (Math.random()) * 10); //항상 0만 나오니 괄호 주의

        //1~10사이의 난수 생성
        //System.out.println((int)(Math.random() * 10) + 1);

        //3 ~ 5 사이의 난수 생성
        System.out.println((int)(Math.random() * 3) + 3);

        //10 - 15
        System.out.println((int)(Math.random() * 6) + 10);

        // -128 - 127 사이
        System.out.println((int)(Math.random() * 256) - 127);

    }
}
