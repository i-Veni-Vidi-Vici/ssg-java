package com.sh.loop._for;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;

/**
 * 중첩반복문
 */
public class For2 {
    public void test1() {
        for (int i = 0; i < 3; i++) {
            System.out.println(i);

            for (int j = 1; j <= 3; j++) {
                System.out.println("\t" + j);
            }
        }
    }

    /**
     * 전체 구구단 출력
     */

    public void test2() {
        // outer loop 2단 ~ 9단
        for (int dan = 2; dan < 10; dan++) {
            System.out.printf("   %d단\n", dan);

            // inner loop 1 ~ 9
            for (int n = 1; n < 10; n++) {
                System.out.printf("%d * %d = %d\n", dan, n, (dan*n));
            }
            System.out.println();
        }
    }

    public void test3() {
        for (int dan = 2; dan < 10; dan++) {
            System.out.printf("   %d단\n", dan);
            // inner loop 1 ~ 9
            printEachDan(dan); // 매개인자
            System.out.println();
        }
    }
    // 선변 호인
    private void printEachDan(int dan) { //매개변수
        // inner loop 1 ~ 9
        for (int n = 1; n < 10; n++) {
            System.out.printf("%d * %d = %d\n", dan, n, (dan*n));
        }
    }

    /**
     * 중첩반복문 - 행/열 표현하기
     * - outer loop -> 행
     * - inner loop -> 열
     */
    public void test4() {
        // 2행 3열
        // 행
        for (int row = 0; row < 2; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print("■ ");
                System.out.printf("(%d, %d)", row, col); //좌표
            }
            System.out.println();
        }
    }

    /**
     * 사용자로부터 행/열 값을 입력받아 별찍기하세요
     * > 행 : 5
     * > 열 : 3
     * ★★★
     * ★★★
     * ★★★
     * ★★★
     * ★★★
     */
    public void test5() {
        Scanner sc = new Scanner(System.in);
        System.out.print("행 : ");
        int row = sc.nextInt();
        System.out.print("열 : ");
        int col = sc.nextInt();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("★");
            }
            System.out.println();
        }
    }

    public void test6() {
        Scanner sc = new Scanner(System.in);
        System.out.print("행수 : ");
        int rowNum = sc.nextInt();
        for (int i=1; i<= rowNum; i++) {
            for (int j=1; j<=i ; j++) {
                System.out.print("★");
            }
            System.out.println();
        }
    }

    /**
     * 알파벳 대문자 E처럼 출력하기
     * ■■■
     * ■
     * ■■■
     * ■
     * ■■■
     * 짝수일 때 세번, 홀수일 때 한번 !
     */

    public void test7() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("■");
            }
            System.out.println();
            if (i<2) {
                System.out.println("■");
            }
        }
    }

    public void test7_2() {
        for (int i = 1; i <= 5; i++) {
            int j = (i % 2) * 2 + 1;
            for ( ; j > 0; j--) {
                System.out.print("ㅁ");
            }
            System.out.println();
        }
    }

    public void test7_ex() {
        for (int i = 0; i < 5; i++) {
            int limit = (i%2 == 0) ? 3 : 1;
            for (int j = 0; j < limit; j++) {
                System.out.print("■");
            }
            System.out.println();
        }
    }
}