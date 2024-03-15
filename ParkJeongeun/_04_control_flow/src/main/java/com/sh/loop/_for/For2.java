package com.sh.loop._for;

import java.util.Scanner;

/**
 * <pre>
 * 중첩반복문
 *
 * </pre>
 */

public class For2 {
    public void test() {
        for (int i = 0; i < 3; i++) {
            System.out.println(i);

            for (int j = 1; j <= 3; j++) {
                System.out.println("\t" + j);
            }
        }
    }

    /**
     * 전체 구구단 출력
     * - 단수 2 ~ 9단 출력 (8번 반복)
     * - 각 단수마다 9번 반복
     */
    public void test2(){
        //outer loop 2 ~9단
        for (int dan = 2; dan <= 9; dan++){
            System.out.println("\t" + dan + "단");

            // inner loop 1 ~ 9
            for (int n = 1; n <= 9; n++) {
                System.out.printf("%d * %d = %d\n", dan, n, dan * n);
            }
            System.out.println();
        }
    }

    /**
     * 중첩반복문 - 메소드
     */
    public void test3(){
        for (int dan = 2; dan <= 9; dan++) {
            printEachDan(dan);
        }
    }

    public void printEachDan(int dan) {
        System.out.println("----" + dan + "단----");
        for (int n = 1; n <= 9; n++) {
            System.out.printf("%d * %d = %d\n", dan, n, dan * n);
        }
    }

    /**
     * 중첩반복문 - 행/열 표현하기
     * - outer loop -> 행
     * - inner loop -> 열
     */

    public void test4(){
        // 2행 3열
        for (int row = 0; row < 2; row++){
            for (int col = 0; col < 3; col++){
//                System.out.print("□ ");
                System.out.printf("(%d, %d)", row, col);
            }
            System.out.println(); // 개행처리
        }
    }

    /**
     * 사용자로부터 행/열 값을 입력받아 별찍기
     * > 행 : 5
     * > 열 : 3
     *
     * ★★★
     * ★★★
     * ★★★
     * ★★★
     * ★★★
     *
     */

    public void test5(){
        Scanner sc = new Scanner(System.in);
        System.out.print("> 행 : ");
        int row = sc.nextInt();
        System.out.print("> 열 : ");
        int col = sc.nextInt();
        for (int i = 1; i <= row; i++){
            for (int j = 1; j <= col; j++){
                System.out.print("★");
            }
            System.out.println();
        }
    }

    /**
     * 행수를 입력받아서 다음과 같이 출력
     * > 행수 : 5
     * ★
     * ★★
     * ★★★
     * ★★★★
     * ★★★★★
     */
    public void test6() {
        Scanner sc = new Scanner(System.in);
        System.out.println("> 행수 : ");
        int row = sc.nextInt();
        for (int i = 1; i <= row; i++){
            for (int j = 1; j <= i; j++){
                System.out.print("★");
            }
            System.out.println();
        }
    }

    /**
     * 알파벳 대문자 E처럼 출력
     * □□□
     * □
     * □□□
     * □
     * □□□
     */
    public void test7(){
        // (나)
//        for (int i = 1; i <= 5; i++) {
//            if (i % 2 == 0) {
//                System.out.println("□");
//            } else {
//                System.out.println("□□□");
//            }
//        }
        // (모범답안)
        for (int i = 0; i < 5; i++){
            int limit = (i % 2 == 0) ? 3 : 1;
            for (int j = 0; j < limit; j++){
                System.out.print("□");
            }
            System.out.println();
        }
    }
}
