package com.sh.loop._for;

import java.util.Scanner;

/**
 * <pre>
 * for문 표현식
 *
 * for(초기식; 조건식; 증감식) {
 *     // 반복실행구문
 * }
 *
 * - 초기식: 증감변수 선언
 * - 조건식: 반복문 실행여부
 * - 증감식: 증감변수 증가/감소처리
 *
 * 실행순서
 * 1. 초기식
 * 2. 조건식: true인 경우
 * 3. 블럭진입 - 반복실행구문
 * 4. 증감식 -> 2번 조건식 이동
 *
 * </pre>
 */
public class For {
    public void test() {
        // 1 ~ 10까지 출력
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }
    }

    public void test5() {
        // 난수가 6일 때, 1~6까지의 합
        int n = (int) (Math.random() * 5) + 6;
        System.out.println(n);
        int sum = 0;
//        if (n == 6) {
//            for (int i = 1; i <= 6; i++) {
//                sum +=i;
//            }
//        } else if (n == 7) {
//            sum += 1;
//            sum += 2;
//            sum += 3;
//            sum += 4;
//            sum += 5;
//            sum += 6;
//            sum += 7;
//
//
//        }

        // 반복횟수, 증감변수의 범위를 난수에 따라 결정
        for (int i = 1; i < n; i++) {
            sum += i;
        }
        System.out.println(sum);
    }

    /**
     * <pre>
     * 사용자로부터 입력받은 단수(2~9)의 구구단 출력
     * - 숫자입력 : 7
     * 7단 출력
     * </pre>
     */
    public void test6() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 1; i <= 9; i++) {
//            System.out.println(num + "x" + i + "=" + num * i);
            System.out.printf("%d * %d = %d\n", num,i, num*i);
        }
    }
}
