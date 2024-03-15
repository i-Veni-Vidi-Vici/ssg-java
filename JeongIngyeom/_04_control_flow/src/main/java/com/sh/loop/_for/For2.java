package com.sh.loop._for;

import javax.script.ScriptContext;
import java.util.Scanner;

/**
 *
 */
public class For2 {
    public void test1() {
        for (int i = 0; i < 3; i++) {
            System.out.println(i);

            for (int j = 1; j < 3; j++) {
                System.out.println("\t" + j);
            }
        }
    }

    /**
     * 전체 구구단 출력
     */
    public void test2() {
        // outer loop
        for (int i = 2; i <= 9; i++) {
            System.out.printf("- %d단 출력\n", i);

            // inner loop
            for (int j = 1; j <= 9; j++) {
                System.out.printf("%d x %d = %d\n", i, j, i * j);
            }
            System.out.println();
        }
    }

    /**
     * 중첩반복문 - 메소드 이용
     */
    public void test3() {
        for (int dan = 2; dan <= 9; dan++) {
            printEachDan(dan);
        }
    }

    public void printEachDan(int dan) {
        System.out.printf("- %d단 출력(메소드로 분리)\n", dan);

        for (int i = 1; i <= 9; i++) {
            System.out.printf("%d x %d = %d\n", dan, i, dan * i);
        }
        System.out.println();
    }

    public void test4() {
        // 행
        for (int row = 0; row < 2; row++) {
            // 열
            for (int col = 0; col < 3; col++) {
//                System.out.print("ㅁ");
                System.out.printf("(%d, %d)", row, col);
            }
            System.out.println();
        }
    }

    /**
     * 사용자로부터 행/열 값을 입력 받아 별찍기하세요.
     * > 행 : 5
     * > 열 : 3
     */
    public void test5() {
        Scanner sc = new Scanner(System.in);

        System.out.print("> 행 : ");
        int row = sc.nextInt();
        System.out.print("> 열 : ");
        int col = sc.nextInt();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("⭐️");
            }
            System.out.println();
        }
    }

    /**
     * 행 수를 입력 받아서 다음과 같이 출력
     * > 행 수 : 5
     */
    public void test6() {
        Scanner sc = new Scanner(System.in);

        System.out.print("> 행 : ");
        int row = sc.nextInt();

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("⭐️");
            }
            System.out.println();
        }
    }

    /**
     * 알파벳 대문자 E처럼 출력하기
     */
    public void test7() {
        for (int i = 1; i <= 5; i++) {
            for (int j = 0; j <= (i % 2) * 2; j++) {
                System.out.print('ㅁ');
            }
            System.out.println();
        }
    }
}
