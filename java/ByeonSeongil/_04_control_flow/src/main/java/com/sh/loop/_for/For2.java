package com.sh.loop._for;

import java.util.Scanner;

/**
 * 중첩반복문
 */
public class For2 {
    public void test() {
        for (int i = 0; i < 3; i++) {
            System.out.println(i);

            for (int j = 1; j <= 5 ; j++) {
                System.out.println("\t"+ j);
            }
        }
    }

    /**
     * <pre>
     * 전체 구구단 출력
     * 2 * 1 = 2
     * 2 * 2 = 4
     *
     * </pre>
     */

    public void test2() {
        // outer loop
        for (int i = 1; i <=9; i++) {
            System.out.println("\t"+i+"단");
            for (int j = 1; j <=9 ; j++) {
                System.out.printf("%d * %d = %d\n", i,j, i*j);;
            }
            System.out.println("---------------");
        }
    }

    /**
     * 중첩반복문 - 메소드
     */
    public void test3() {
        for (int dan = 2; dan <= 9 ; dan++) {
            printEachDan(dan);
        }
    }

    public void printEachDan(int dan) {
        for (int n = 1; n <= 9; n++) {
            System.out.printf("%d * %d = %d\n",dan,n,dan *n);
        }
    }

    /**
     * 중첩반복문 - 행/렬 표현하기
     * - outer loop -> 행
     * - inner loop -> 열
     */
    public void test4() {
        // 2행 3열
        // 행
        for (int row = 0; row < 2; row++) {
            // 열
            for (int col = 0; col < 3; col++) {
//                System.out.print("□ ");
                System.out.printf("(%d, %d)", row, col);
            }
            System.out.println();
        }
    }

    /**
     * 사용자로부터 행/열 값을 입력 받아 별찍기하세요.
     * ex)
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
        System.out.print("행:");
        int row = sc.nextInt();
        System.out.print("열:");
        int col = sc.nextInt();

        String star = "★".repeat(Math.max(0, col));

        for (int i = 0; i < row; i++) {
            System.out.println(star);
        }
    }

    /**
     * <pre>
     * 행수를 입력받아서 다음과 같이 출력
     * ex)
     * > 행수 : 5
     * ★
     * ★★
     * ★★★
     * ★★★★
     * ★★★★★
     * </pre>
     */
    public void test6() {
        StringBuilder bd = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        System.out.println("행 입력:");
        int row = sc.nextInt();
        for (int i = 0; i < row; i++) {
            bd.append("★");
            System.out.println(bd);
        }
    }

    /**
     * 알파벳 대문자 E처럼 출력하기
     */

    public void test7() {
        for (int i = 0; i < 5; i++) {
            int limit = (i%2==0)?3:1;
            for (int j = 0; j < 3; j++) {
                System.out.println("□");
            }
            System.out.println();

        }
    }
}
