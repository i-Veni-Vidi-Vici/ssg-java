package com.sh.loop._while;

import java.util.Scanner;

/**
 * <pre>
 *     do-while표현식
 *     - 조건식 -> 반복실행 순으로 처리되는 다른 반복문(for문, while문)과 달리
 *     - 일단 1회 실행 후 조건을 검사하도록 처리
 *     - 조건 여부와 상관 없이 최소 1회는 실행되어야 할 흐름에 적합하다. 예를 들어, 메뉴 노출, 게임실행 등
 *      - do {} 블럭 안에 선언한 변수는 밖에서 접근할 수 없으므로, while 조건식에서 사용할 수 없음
 *
 *     초기식;
 *     do {
 *         // 반복실행구문
 *         증감식;
 *     } while(조건식);
 * </pre>
 */

public class DoWhile {
    public void test1() {
        Scanner sc = new Scanner(System.in);
        char yn;

        do {
            System.out.println("게임실행...얇ㅃ짝퉁...");
            System.out.println("한판 더 하시겠습니까? y/n : ");
            yn = sc.next().charAt(0);
        }while(yn == 'y');

        System.out.println("게임 종료...");
    }

    /**
     * exit를 입력하기 전까지 무한입력 가능
     */
    public void test2() {
        Scanner sc = new Scanner(System.in);
        String str = "";
        do {
            System.out.println("문자열을 입력하세요. (중지하려면 exit) : ");
            str = sc.nextLine();
            System.out.println("> " + str);
        } while(str.equals("exit") == false);        // 문자열 내용은 ==가 아닌 equals() 메소드로 비교
    }
}
