package com.sh.loop._while;

import java.util.Scanner;

/**
 * <pre>
 * do~while 표현식
 * - 조건식 -> 반복실행 순으로 처리되는 일반 반복문(for, while)과 달리
 * - 일단 1회 실행 후 조건을 검사하도록 처리하는 반복문
 * - 조건여부와 상관없이 최소 1회는 실행되어야 할 흐름에 적합하다. 메뉴노출, 게임실행 등
 * </pre>
 */
public class DoWhile {
    public void test1() {
        Scanner sc = new Scanner(System.in);
        char yn ;
        do {
            System.out.println("게임실행...start...");
            System.out.println("한판 더 하시겠습니까? y/n :");
            yn = sc.next().charAt(0);
          } while (yn == 'y');

        System.out.println("게임종료");
    }

    /**
     * exit을 입력하기 전까지 무한입력이 가능한 앱
     */
    public void test2() {
        Scanner sc = new Scanner(System.in);
        String str; // while 조건식에 사용할 변수는 do블럭 밖에 선언하기
        do {
            System.out.println("문자열을 입력하세요. (중지하려면 exit) :");
            str = sc.nextLine();
            System.out.println("> " + str);
            // 기본형이 아닌 문자열은 "=="가 아닌 equals 메소드를 통해 동등비교해야 한다.
        } while (!str.equals("exit")); // 입력값이 exit일때 탈출하도록 false인 조건식 작성해야 한다.
    }
}
