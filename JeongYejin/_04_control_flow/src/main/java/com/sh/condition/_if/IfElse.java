package com.sh.condition._if;

import java.util.Scanner;

/**
 * if~else 표현식
 *
 * if (조건식) {
 *     // 조건식이 true인 경우 실행코드
 * }
 * else {
 *     // 조건식이 false인 경우 실행코드
 * }
 * 실행블럭의 코드가 단 한줄인 경우만 {} 블럭을 생략할 수 있다.
 */

public class IfElse {
    public void test() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        // num % 2 == 1, num % 2 != 0
        if (num % 2 == 1) {
            // 조건식이 true : 홀수일 때 실행코드
            System.out.println("홀수 🍔🍔🍔");
        }
        else {
            // 조건식이 false : 짝수일 때 실행코드
            System.out.println("짝수 🍕🍕🍕");
        }
        System.out.println("프로그램 종료!!!");
    }

    /**
     * 사용자 성별(M/F) 입력받고, 남자인 경우 장난감을, 여자인 경우 장미꽃을 출력하세요.
     */
    public void test2() {
        Scanner sc = new Scanner(System.in);
        System.out.print("성별을 입력하세요 (M/F) : ");
        char sex = sc.next().charAt(0);
        if (sex == 'M'){
            System.out.println("🚓🚓🚓");
        }
        else {
            System.out.println("🌹🌹🌹");
        }
    }

    /**
     * 사용자 입력 정수에 따라 양수/0/음수 출력하세요!
     * - 중첩 if 사용가능
     */

    public void test3() {
        Scanner sc = new Scanner(System.in);
        System.out.println("정수를 입력하세요 : ");
        int n = sc.nextInt();
        if (n >= 0) {
            if (n == 0) {
                System.out.println("0");
            } else {
                System.out.println("양수");
            }
        } else {
            System.out.println("음수");
        }
    }
}
