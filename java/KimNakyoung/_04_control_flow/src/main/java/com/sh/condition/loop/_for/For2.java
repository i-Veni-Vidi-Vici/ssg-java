package com.sh.condition.loop._for;

import java.util.Scanner;

public class For2 {
    public void test1() {
        for (int i = 0; i < 3; i++) {
            System.out.println(i);

            for (int j = 1; j <= 3; j++) {
                System.out.println("\t" + j); // \t 들여쓰기
            }
        }
    }

    /**
     * 전체 구구단 출력
     */
    public void test2() {
        for (int dan = 2; dan <= 9; dan++) {
            System.out.println(dan + "단");
            for (int n = 1; n <= 9; n++) {
//               System.out.println(dan + " + " + n + " = " + dan * n);

                System.out.printf("%d * %d = %d\n", dan, n, dan * n);
            }
            System.out.println();
        }
    }

    /**
     * 중첩반복문 - 메소드
     */

    public void test3() {
        for (int dan = 2; dan <= 9; dan++) {
            printEachDan(dan);

        }
    }

    public void printEachDan(int dan) {
        System.out.println("---" + dan + "단----");
        for (int n = 1; n <= 9; n++) {
            System.out.printf("%d * %d = %d\n", dan, n, dan * n);
        }
        System.out.println();
    }

    /**
     * 중첩반복문 - 행/열 표현하기
     * - outer loop -> 행
     * - inner loop -> 열
     */

    public void test4() {
        // 2행 3열
        for (int row = 0; row < 2; row++) {

            for (int col = 0; col < 3; col++) {
                System.out.printf("(%d,%d)", row, col); // 좌표표현가능
            }
            System.out.println();
        }
    }

    /**
     * 사용자로부터 행/열 값을 입력 받아 별찍기 하세요
     * > 행 : 5
     * > 열 : 3
     * <p>
     * ***
     * ***
     * ***
     * ***
     * ***
     */

    public void test5() {
        Scanner sc = new Scanner(System.in);
        System.out.print("> 행 :");
        int row = sc.nextInt();
        System.out.print("> 열 :");
        int col = sc.nextInt();

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void test6() {
        Scanner sc = new Scanner(System.in);
        System.out.print("> 행수 : ");
        int row = sc.nextInt();

        for (int i = 1; i <= row; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     * 알파벳 대문자 E처럼 출력하기
     *
     * □□□
     * □
     * □□□
     * □
     * □□□
     */

    public void test7() {

        for (int i = 0; i < 5; i++) {
                int limit = ( i % 2 == 0) ? 3 : 1;
                for (int j = 0; j < limit; j++) {
                    System.out.print("□");
                }
            System.out.println();
        }
    }


}


