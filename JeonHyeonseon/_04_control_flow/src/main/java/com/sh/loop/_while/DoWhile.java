package com.sh.loop._while;

import java.util.Scanner;

/**
 * <pre>
 * do~while표현식 : 조건식 - 반복실행 순으로 처리되는 일반 반복문(for, while)과 달리
 * - 일단 1회 실행후 조건을 검사하도록 처리하는 반복문
 * - 조건여부와 상관없이 최소1회는 실행되어야 할 흐름에 적합하다. 메뉴노출 , 게임실행 등
 *
 * do {
 *      // 반복실행구문
 *       증감식;
 * } while (조건식);
 *
 *
 * </pre>
 */

public class DoWhile {
    public void test1() {
        Scanner sc = new Scanner(System.in);
        char yn;

        do {
            System.out.println("게임실행....얇빡쿵...");
            System.out.println("한 판 더 하시겠습니다? y/n : ");
            yn = sc.next().charAt(0);
        } while (yn == 'y');  // 탈출할 조건을 작성한 것

        System.out.println("게임 종료..");
    }

    /**
     * exit를 입력하기전까지 무한입력 가능 앱
     */
    public void test2() {
        Scanner sc = new Scanner(System.in);
        String str; // while조건식에 사용할 변수는 do블럭 밖에 선언하기 -> str 선언
        do {  // 아무것도 검사하지 않고 무조건 검사부터 시작한다.
            System.out.println("문자열을 입력하세요. (중지하려면 exit) : ");
            str = sc.nextLine();
            System.out.println("> " + str);
            // 기본형이 아닌 문자열은 ==가 아닌 equals메소드(같다는 의미)를 통해 동등비교해야 한다.
        } while(!str.equals("exit")); // 입력값이 exit일 때 false인 조건식 작성 / exit와 같지 않다면 탈출해주세요
    }
}
