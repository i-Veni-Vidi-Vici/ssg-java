package com.sh.condition._if;

import java.util.Scanner;

/**
 * if~else 표현식
 * if (조건식) {
 *     조건식 == true
 * }
 * else {
 *     조건식 == false
 * }
 * 실행블럭의 코드가 단 한줄인 경우만 {}블럭을 생략할 수 있다.
 */
public class IfElse {
    public void test1() {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수를 입력: ");
        int num = sc.nextInt();

        if (num % 2 == 0) {
            System.out.println("짝수");
        }
        else {
            System.out.println("홀수");
        }

        System.out.println("end!");
    }

    /**
     * 사용자 성별(M/F) 입력받고, 남자인 경우 장난감을, 여자인 경우, 장미꽃을 출력하세요.
     */
    public void test2() {
        Scanner sc = new Scanner(System.in);
        System.out.print("성별 입력(M/F): ");
        char gender = sc.next().charAt(0);

        if (gender == 'M') {
            System.out.println("장난감");
        }
        else {
            System.out.println("장미꽃");
        }

        System.out.println("end!");
    }

    /**
     * 사용자 입력 정수에 따라 양수/0/음수 출력하세요!
     */
    public void test3() {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수 입력: ");
        int num = sc.nextInt();

        if (num > 0) {
            System.out.println("양수");
        }
        else {
            if (num == 0) {
                System.out.println("0");
            }
            else  {
                System.out.println("음수");
            }
        }

        System.out.println("end!");
    }
}
