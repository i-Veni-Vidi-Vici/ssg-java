package com.sh.loop_for;


import java.util.Scanner;

/**
 * 중첩반복문
 */
public class For2 {
    public void test1() {
        for (int i = 0; i < 3; i++) {
            System.out.println(i);

            for (int j = 1; j <= 3; j++) {
                System.out.println("\t" + j); //증감변수는 각기 달라야 함
                // 바깥 for 문이 한번 실행될 때 안쪽 for 문 세번 실행
            }

        }

    }

    /**
     * <pre>
     * 전체 구구단 출력
     *
     * 2 * 1 = 2
     * 2 * 2 = 4
     * 2 * 3 = 6
     *
     * ~
     *
     *
     * 9 * 1 = 9
     * 9 * 2 = 18
     *
     * 9 * 9 = 81
     * </pre>
     */

    public void test2() {
        // outer loop 2 ~ 9단
        for (int i = 2; i < 10; i++) {

            System.out.println(i);
            // inner loop 1 ~ 9
            for (int j = 1; j < 10; j++) {
//                System.out.println("\t" + j);
                System.out.printf("%d * %d = %d\n", i, j, i * j);
            }

        }


    }

    public void test3() {
        for (int dan = 2; dan <= 9; dan++) {
            printEachDan(dan);
        }
    }

    public void printEachDan(int dan) {
        System.out.println("----" + dan + "단 ----");
        for (int n = 1; n <= 9; n++) {
            System.out.printf("%d * %d = %d\n", dan, n, dan * n);
        }
    }

    /**
     * 중첩반복문 - 행/열 표현
     * - outer loop -> 행 의미
     * - inner loop -> 열 의미
     */
    public void test4() {
        //행
        for (int row = 0; row < 2; row++) {

            for (int col = 0; col < 3; col++) {
//                System.out.print("■ ");
                System.out.printf("(%d, %d)", row, col);
            }
            System.out.println(); //개행처리

        }
    }

    /**
     * 사용자로부터 행/열 값을 입력 받아 별찍기하세요
     * > 행 : 5
     * > 열 : 3
     * <p>
     * ★★★
     * ★★★
     * ★★★
     * ★★★
     * ★★★
     */
    public void test5() {
        Scanner sc = new Scanner(System.in);
        int row, col;


        System.out.println("행의 개수를 입력하세요 : ");
        row = sc.nextInt();
        System.out.println("열의 개수를 입력하세요 : ");
        col = sc.nextInt();


        for (int i = 0; i < row; i++) { // i가 row 보다 작을떄 까지만 증가해라
            for (int j = 0; j < col; j++) { // i가 col 보다 작을 때 까지만 증가해라
                System.out.printf("ㅁ");
            }
            System.out.println();
        }


    }


    /**
     * 알파벳 대문자 E처럼 출력하기
     *
     */
    public void test7(){

        for (int row = 0; row <5; row ++ ) {
            if (row % 2 == 0) {
                for (int col = 0; col < 3; col++) {

                    System.out.printf("ㅁ");
                }
                System.out.println();
            } else {
                System.out.printf("ㅁ");
                System.out.println();
            }

        }

    }



}


