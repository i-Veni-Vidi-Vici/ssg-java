package com.sh.loop._for;

import java.util.Scanner;

/**
 * 중첩반복문
 */
public class For2 {
    public void test1() {
        for(int i = 0; i < 3; i++) {
            System.out.println(i);

            for(int j = 1; j <= 3; j++) {
                System.out.println("\t" + j);
            }
        }
    }

    /**
     * 전체 구구단 출력
     *
     * 2 * 1 = 2
     * 2 * 2 = 4
     * 2 * 3 = 6
     * ...
     *
     * 3 * 1 = 3
     * 3 * 2 = 6
     * 3 * 3 = 9
     * ...
     *
     * 9 * 1 = 9
     * 9 * 2 = 18
     * 9 * 3 = 27
     * ...
     * 9 * 9 = 81
     */
    public void test2() {
        // outer loop 2단 ~ 9단 (8번)
        for(int dan = 2; dan <= 9; dan++) {
//            System.out.println(dan);
            // inner loop 1 ~ 9 (9번)
            System.out.println("\t" + dan + "단");
            for(int n = 1; n <= 9; n++) {
//                System.out.println("\t" + n);
                System.out.printf("%d * %d = %d\n", dan, n, dan * n);
            }
            System.out.println();
        }
    }

    /**
     * 중첩반복문 - 메소드
     */
    public void test3() {
        for(int dan = 2; dan <= 9; dan++) {
            printEachDan(dan);
        }
    }

    public void printEachDan(int dan) {
        System.out.println("---" + dan + "단---");
        for(int n = 1; n <= 9; n++) {
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
        // 행
        for(int row = 0; row < 2; row++) {
            // 열
            for(int col = 0; col < 3; col++) {
//                System.out.print("□ ");
                System.out.printf("(%d, %d)", row, col);
            }
            System.out.println(); // 개행처리
        }
    }

    /**
     * 사용자로부터 행/열 값을 입력 받아 별찍기하세요.
     * > 행 : 5
     * > 열 : 3
     *
     * ★★★
     * ★★★
     * ★★★
     * ★★★
     * ★★★
     */
    public void test5() {
        Scanner sc = new Scanner(System.in);
        System.out.print("> 행 : ");
        int row = sc.nextInt();

        System.out.print("> 열 : ");
        int col = sc.nextInt();
        System.out.println();

        // row번 반복
        for(int i = 0; i < row; i++) {
            // col번 반복
            for(int j = 0; j < col; j++) {
                System.out.print("★");
            }
            System.out.println();
        }
    }

    /**
     * <pre>
     * 행수를 입력받아서 다음과 같이 출력
     * > 행수 : 5
     * ★
     * ★★
     * ★★★
     * ★★★★
     * ★★★★★
     * </pre>
     */
    public void test6() {
        Scanner sc = new Scanner(System.in);
        System.out.print("> 행수 : ");
        int row = sc.nextInt();

        for(int i = 0; i < row; i++) {
            for(int j = 0; j <= i; j++) {
                System.out.print("★");
            }
            System.out.println();
        }

        // 자기주도학습
        // 별 앞에 공백을 두고 뒤부터 별 나오게 하기
//        for(int i = 0; i < row; i++) {
//            for(int j = 0; j < row - i; j++) {
//                System.out.print(" ");
//            }
//            for(int k = 0; k < i + 1; k++) {
//                System.out.print("★");
//            }
//            System.out.println();
//        }
    }

    /**
     * 알파벳 대문자 E처럼 출력하기
     * □□□
     * □
     * □□□
     * □
     * □□□
     */
    public void test7() {
        for(int i = 0; i < 5; i++) {
            if(i % 2 == 0) {
                for(int j = 0; j < 3; j++) {
                    System.out.print("□");
                }
            } else {
                System.out.print("□");
            }
            System.out.println();
        }
    }
}
