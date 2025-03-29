package com.sh.loop._for;

import java.util.Scanner;

/**
 * <pre>
 *     중첩 반복문
 *
 * </pre>
 */

public class For2 {
    public void test1() {
        for (int i = 0; i < 3; i++) {
            System.out.println(i);

            for (int j = 1; j <= 5; j++) {
                System.out.println("\t" + j);
            }
        }
    }

    /**
     * 전체 구구단 출력
     * <p>
     * 각 단수별로 9번 반복
     * 각 단은 2단, 3단, ... 9단으로 8번 반복
     * <p>
     * 2 * 1 = 2
     * 2 * 2 = 4
     * 2 * 3 = 6
     * <p>
     * ...
     * <p>
     * 3 * 1 = 3
     * 3 * 2 = 6
     * 3 * 3 = 9
     * <p>
     * ...
     * <p>
     * 9 * 1 = 9
     * 9 * 2 = 18
     * 9 * 3 = 27
     * <p>
     * ...
     * <p>
     * 9 * 9 = 81
     */

    public void test2() {
        // outer loop 2단 ~ 9단 (8번)
        for (int dan = 2; dan <= 9; dan++) {
//           System.out.println(dan);
            System.out.println("\t" + dan + "단");
            // inner loop 1 ~ 9 (9번)
            for (int n = 1; n <= 9; n++) {
//               System.out.println("\t" + n);
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
        for (int n = 1; n <= 9; n++) {
            System.out.printf("%d * %d = %d\n", dan, n, dan * n);
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
//                System.out.print("□ ");
                System.out.printf("(%d, %d)", row, col);
            }
            System.out.println(); // 줄바꿈
        }
    }

    /**
     * 사용자로부터 행/열 값을 입력 받아 별 출력
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
        int row = 0;
        int col = 0;

        System.out.println("행 : ");
        row = sc.nextInt();
        System.out.println("열 : ");
        col = sc.nextInt();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("★");
            }
            System.out.println();
        }
    }

    /**
     * 사용자로부터 행 값을 입력 받아 별 출력
     * > 행 : 5
     * ★
     * ★★
     * ★★★
     * ★★★★
     * ★★★★★
     */
    public void test6() {
        Scanner sc = new Scanner(System.in);
        int row = 0;

        System.out.println("행 : ");
        row = sc.nextInt();

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("★");
            }
            System.out.println();
        }
    }

    /**
     * 알파벳 대문자 E처럼 출력하기, 5행 3열 빈칸이 있는 것과 같음
     * 0 나머지 0 3 □□□
     * 1 나머지 1 1 □
     * 2 나머지 0 3 □□□
     * 3 나머지 1 1 □
     * 4 나머지 0 3 □□□
     */
    public void test7() {
        for (int i = 0; i < 5; i++) {
            int limit = (i % 2 == 0) ? 3 : 1;
            for (int j = 0; j < limit; j++) {
                System.out.print("★");
            }
            System.out.println();

        }
    }
}
