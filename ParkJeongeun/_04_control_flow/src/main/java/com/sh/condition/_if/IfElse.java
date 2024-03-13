package com.sh.condition._if;

import java.util.Scanner;

/**
 * <pre>
 * if-else 표현식
 * if (조건식) {
 *     // 조건식이 true인 경우 실행코드
 * } else {
 *     // 조건식이 false인 경우 실행코드
 * }
 *
 * 실행블럭의 코드가 단 한줄인 경우만 {} 블럭 생략가능
 * </pre>
 */

public class IfElse {
    public void test() {
        Scanner sc = new Scanner(System.in);
        // 사용자 입력 정수에서 홀수/짝수 구분
        System.out.println("> 정수 입력 : ");
        int num = sc.nextInt();

        if(num % 2 != 0){
            // true : 홀수일때
            System.out.println("홀수 🍔🍔🍔");

        } else {
            // false : 짝수일때
            System.out.println("짝수 🍗🍗🍗");

        }
        System.out.println("프로그램 종료!!!");
    }

    /**
     * 사용자 성별 입력받고, 남자인 경우 장난감, 여자인 경우 장미꽃 출력
     */
    public void test2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("> 성별 입력 (M / F) : ");
        char gender = sc.next().charAt(0);
        if (gender == 'F') {
            System.out.println("장미꽃 🌹🌹🌹");
        } else {
            System.out.println("장난감 🐱‍👤🐱‍👤🐱‍👤");
        }
    }

    /**
     * 사용자 입력 정수에 따라 양수/0/음수 출력
     * - 중첩 if 사용가능
     */

    public void test3() {
        Scanner sc = new Scanner(System.in);
        System.out.println("> 정수 입력 : ");
        int num = sc.nextInt();
        if (num != 0) {
            if (num > 0) {
                System.out.println(num + "은 양수");
            } else {
                System.out.println(num + "은 음수");
            }
        } else {
            System.out.println(num + "은 0");
        }
    }

}
