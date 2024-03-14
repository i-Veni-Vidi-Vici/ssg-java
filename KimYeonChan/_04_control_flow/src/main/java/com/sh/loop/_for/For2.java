package com.sh.loop._for;

import java.util.Scanner;

public class For2 {
    public void test1() {
        for (int i = 0; i < 3; i++) {
            System.out.println((i));
            for (int j = 1; j <= 3; j++){
                System.out.println("\t" + j);
            }
        }
    }

    // 전체 구구단 줄
    public void test2() {
        for (int i = 2; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                System.out.printf("%d * %d = %d\n", i, j, i * j);
            }
            System.out.print("\n");
        }
    }

    // 중첩반복문: 메소드
    public void test3() {
        for (int i = 2; i <= 9; i++) {
            printEachDan(i);
        }
    }

    public void printEachDan(int dan) {
        System.out.printf("===%d단===\n", dan);
        for (int j = 1; j <= 9; j++) {
            System.out.printf("%d * %d = %d\n", dan, j, dan * j);
        }
    }

    public void test4() {
        for (int row = 0; row < 2; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.printf("(%d, %d)", row, col);
            }
            System.out.println();
        }
    }

    /**
     * 사용자로부터 행/열 값을 입력 받아 별찍기 하세요.
     */
    public void test5() {
        Scanner sc = new Scanner(System.in);
        System.out.print("행 입력: ");
        int row = sc.nextInt();
        System.out.print("열 입력: ");
        int col = sc.nextInt();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     * 5
     * *
     * **
     * ***
     * ****
     * *****
     */
    public void test6() {
        Scanner sc = new Scanner(System.in);
        System.out.print("행 입력: ");
        int row = sc.nextInt();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                if (j <= i){
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }

    /**
     * ***
     * *
     * ***
     * *
     * ***
     */
    public void test7() {
//        for (int i = 0; i < 5; i++) {
//            if (i % 2 == 0) {
//                for (int j = 0; j < 3; j++) {
//                    System.out.print("*");
//                }
//            }
//            else {
//                System.out.print("*");
//            }
//            System.out.println();
//        }

        for (int i = 0; i < 5; i++) {
            int limit = (i % 2 == 0) ? 3 : 1;
            for (int j = 0; j < limit; j++) {
                System.out.print("*");
            }
        }
    }
}