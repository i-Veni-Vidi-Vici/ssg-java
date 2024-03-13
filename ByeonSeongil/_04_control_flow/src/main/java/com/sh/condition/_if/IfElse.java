package com.sh.condition._if;

import java.util.Scanner;

/**
 * if-else 표현식
 * <p>
 * if(조건식) {
 * // 조건식이 true인 경우 실행코드
 * } else{
 * // 조건식이 false인 경우 실행코드
 *
 * 실행블럭의 코드가 다 한줄인 경우마 {}블록을 생략할 수 있다.
 * }
 */
public class IfElse {
    public void test() {
        Scanner sc = new Scanner(System.in);

        // 사용자 입력 정수 홀/짝 구분
        System.out.print("> 정수 입력 : ");
        int num = sc.nextInt();

        if (num % 2 == 1) {
            // 조건식이 true: 홀수 일때 실행코드
            System.out.println("홀수 (●'◡'●)");
        } else {
            // 조건식이 false: 짝수 일때 실행코드
            System.out.println("짝수 ╰(*°▽°*)╯");
        }
        System.out.println("프로그램 종료!!!");


    }

    /**
     * 사용자 성별 입력하고, 남자인 경우 장난감을, 여자인 경우, 장미꽃을 출력하세요.
     */

    Scanner sc = new Scanner(System.in);

    public void test2() {
        System.out.print("성별 :");
        char gender = sc.next().charAt(0);
        if (gender == 'M') {
            System.out.println("장난감");
        } else if (gender == 'F') {
            System.out.println("꽃");
        }
    }

    /**
     * 사용자 입력 정수에 따라 양수/0/음수 출력하세요!
     * - 중첩 if사용가능
     */
    public void test3() {
        System.out.print("정수 :");
        int number = sc.nextInt();

        if (number < 0) {
            System.out.println("음수");
        } else if (number > 0) {
            System.out.println("양수");
        } else System.out.println("0");
    }
}
