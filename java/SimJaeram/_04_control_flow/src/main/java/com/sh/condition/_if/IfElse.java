package com.sh.condition._if;

import java.util.Scanner;

/**
 * <pre>
 * if~else 표현식
 *
 * if() {
 * // 조건식이 true인 경우 실행코드
 * } else {
 * // 조건식이 false인 경우 실행코드
 * }
 *
 * 실행 블럭의 코드가 단 한줄인 경우만 {} 블럭을 생략할 수 있다.
 * </pre>
 */

public class IfElse {

    // 사용자 입력 정수, 홀수/짝수 구분
    public void test() {
        Scanner sc = new Scanner(System.in);

        System.out.println("> 정수 입력 : ");
        int num = sc.nextInt();

        if (num % 2 == 1) {
            // 조건식이 true : 홀수일 때 실행코드
            System.out.println("홀수 🍔🍔🍔");
        } else {
            // 조건식이 false : 짝수일 때 실행코드
            System.out.println("짝수 🍖🍖🍖");
        }

        System.out.println("프로그램 종료!!!");
    }

    /**
     * 사용자 입력 성별 (M/F), 남자인 경우 장난감/여자인 경우 장미꽃 출력
     */
    public void test2() {
        Scanner sc = new Scanner(System.in);

        System.out.println("> 성별 입력 (M/F) : ");
        char gender = sc.next().charAt(0);

        if (gender == 'M') {
            System.out.println("장난감 🚗🚗🚗");
        } else {
            System.out.println("장미꽃 🌹🌹🌹");
        }

        System.out.println("프로그램 종료!!!");
    }

    /**
     * 사용자 입력 정수, 양수/0/음수 출력
     * - 중첩 if 사용가능
     */

    public void test3() {
        Scanner sc = new Scanner(System.in);

        System.out.println("> 정수 입력 : ");
        int num = sc.nextInt();

//        if(num > 0) {                           // 입력된 정수가 0보다 크면 양수
//            System.out.println("양수");
//        } else {                                // 입력된 정수가 0보다 크지 않으므로, 0 또는 음수
//          if(num == 0) {
//              System.out.println("0");
//          }
//          else {
//              System.out.println("음수");
//          }
//        }

        // 위와 같은 방식으로 나누어도 되고, 0인 경우와 0이 아닌 경우에서 양수인 경우와 음수인 경우로 나눌 수 있음

        if(num == 0) {
            System.out.println("0");
        } else {
            if(num > 0) {
            System.out.println("양수");
            } else {
                System.out.println("음수");
            }
        }

        System.out.println("프로그램 종료!!!");
    }
}
