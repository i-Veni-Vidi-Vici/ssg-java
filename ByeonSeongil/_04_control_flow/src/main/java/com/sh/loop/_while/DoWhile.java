package com.sh.loop._while;

import java.util.Scanner;

/**
 *
 */
public class DoWhile {
    public void test1() {
        Scanner sc = new Scanner(System.in);
        char yn;

        do {
            System.out.println("게임실행");
            System.out.println("한번 더 y/n");
            yn = sc.next().charAt(0);
        } while (yn == 'y');

        System.out.println("게임 종료");

    }

    /**
     * exit를 입력하기전까지 무한입력 가능 앱
     */

    public void test2() {
        Scanner sc = new Scanner(System.in);
        String str; // while조건식에 사용할 변수는 do블럭 밖에 선언하기
        do {
            System.out.println("문자열을 입력하세요. (중지하려면 exit) : ");
            str = sc.nextLine();
            System.out.println(">" + str);
            // 기본형이 아닌 문자열은 ==대신 equals로 비교
        } while (!str.equals("exit"));
    }
}
