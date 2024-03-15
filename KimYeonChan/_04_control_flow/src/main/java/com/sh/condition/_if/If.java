package com.sh.condition._if;

import java.util.Scanner;

/**
 * if 표현식
 * if (조건식) {
 *     // 조건식이 true 인 경우 실행코드
 * }
 */
public class If {
    public void test1() {
        Scanner sc = new Scanner(System.in);
        // 짝수 입력값인 경우 빵빠레!
        System.out.print("> 정수를 입력: ");
        int num = sc.nextInt();

        if (num % 2 == 0) {
            System.out.println("짝수 짝짝짝");
        }
        if (num < 0) {
            System.out.println("음수 빵빵빵");
        }

        System.out.println("프로그램 종료!");
    }

    public void test2() {
        Scanner sc = new Scanner(System.in);
        // 사용자 입력 정수, 양수 이면서, 짝수인지 체크
        System.out.print("> 정수를 입력: ");
        int num = sc.nextInt();

        if (num > 0) {
            if (num % 2 == 0) {
                System.out.println("양수 & 짝수 빵빵빵");
            }
        }

        System.out.println("프로그램 종료!");
    }
}
