package com.sh.loop._while;

import java.util.Objects;
import java.util.Scanner;

/**
 * - 조건식 -> 반복실행 순으로 처리되는 일반 반복문(for, while)과 달리
 * - 일단 1회 실행 후 조건을 검사하도록 처리하는 반복문
 * do~while 표현식
 * 초기식;
 * do {
 *     // 반복실행구문
 *     증감식;
 * } while (조건식);
 */
public class DoWhile {
    public void test1() {
        Scanner sc = new Scanner(System.in);
        char isRestart = ' ';
        do {
            System.out.println("게임실행...");
            System.out.println("한판 더 하시겠습니까? y/n");
            isRestart = sc.next().charAt(0);
        } while (isRestart == 'y');

        System.out.println("게임종료");
    }

    /**
     * exit 을 입력하기전까지 무한입력 가능 앱
     */
    public void test2() {
        Scanner sc = new Scanner(System.in);
        String str = "";

        do {
            System.out.println("문자열을 입력하세요.(중지하려면 exit): ");
            str = sc.nextLine();
            System.out.println("> " + str);
        } while (!str.equals("exit"));
    }
}
