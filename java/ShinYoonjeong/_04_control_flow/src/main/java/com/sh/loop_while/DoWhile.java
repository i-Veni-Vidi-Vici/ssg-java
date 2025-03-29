package com.sh.loop_while;

import java.util.Scanner;

/**
 * do~while 표현식
 * - 조건식 - 반복실행 순으로 처리되는 일반 반복문(for, while)과 달리
 * - 일단 1회 실행 후 조건을 검사하도록 처리하는 반복문
 * - 조건 여부와 상관 없이 최소 1회는 실행되어야 할 흐름에 적합하다. 메뉴 노출, 게임 실행 등
 *
 * 초기식;
 * do {
 *     // 반복실행구문
 *     증감식;
 * } while (조건식);
 */
public class DoWhile {
    Scanner sc = new Scanner(System.in);
    char yn;
    public void test1(){
        do {
            System.out.println("게임 실행....");
            System.out.println("한판 더 하시겠습니까? y/n : ");
            yn = sc.next().charAt(0);
        } while(yn == 'y');
        System.out.println("게임 종료....");
    }
    public void test2(){
        Scanner sc = new Scanner(System.in);
        String str; // while 조건식에 사용할 변수는 do블럭 밖에 선언하기
        do {
            System.out.println("문자열을 입력하세요. (중지하려면 exit) : ");
            str = sc.nextLine();
            System.out.println("> " + str);
            // 기본ㅕㅇ이 아닌 문자열은 ==가 아닌 equals메소드를 통해 동등 비교해야 한다.
        } while(!str.equals("exit")); // 입력값이 exit일때 false인 조건식 작성
    }

}
