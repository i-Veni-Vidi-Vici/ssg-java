package com.sh.loop._for;


import java.util.Scanner;

/**
 *  중첩 반목문
 */
public class For2 {
    public void test1() {
        for (int i = 0; i < 3; i++) {
            System.out.println(i);

            for (int j = 1; j < 5; j++) {
                System.out.println("\t" + j);
            }
        }
    }

    /**
     * 전체 구구단 출력
     */
    public void test2() {
        //outer loop 2단 ~ 9단 (8번)
        for (int i = 2; i <= 9; i++) {
            System.out.println(i + "단 입니다🍀");

            //inner loop 1 ~ 9 (9번)
            for (int j = 1; j <= 9; j++) {
                System.out.println( i + " * " + j + " = " + i*j);
            }
            System.out.println("");
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
        System.out.println(dan + "단 입니다🍀");
        for (int n = 1; n <= 9; n++){
            System.out.printf( "%d * %d = %d\n", dan, n, dan * n);
        }
        System.out.println("");
    }

    /**
     * 중첩 반복문 - 행렬 표현이 가능함
     * - outer loop -> 행을 의미함
     * - inner loop → 열
     */

    public void test4() {
        //2행 3열

        //행
        for (int row = 0; row < 2; row++) {
            //열
            for (int col = 0; col < 3; col++) {
                System.out.print("🥑");
                System.out.printf("(%d, %d)", row, col);
            }
            System.out.println(); // 개행 처리
        }
    }

    /**
     * 사용자로부터 행/열을 입력 받아 별찍기 하세요
     */

    public void test5() {
        Scanner sc = new Scanner(System.in);
        System.out.print("몇 행일까요? : ");
        int row = sc.nextInt();

        System.out.print("몇 열일까요? : ");
        int col = sc.nextInt();

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                System.out.print("🌟");
            }
            System.out.println("");
        }
    }

    /**
     * 행 수를 입력 받아서 다음과 같이 출력
     * 행수 : 5
     * 🌟
     * 🌟🌟
     * 🌟🌟🌟
     * 🌟🌟🌟🌟
     * 🌟🌟🌟🌟🌟
     */

    public void test6() {
        Scanner sc = new Scanner(System.in);
        System.out.println("몇 행이야 ? : ");
        int row = sc.nextInt();

        for (int i = 1; i <= row; i++) {

            for (int j = 1; j <= i; j++) {
                System.out.print("🌟");
            }
            System.out.println(" ");
        }
    }

    /**
     * 알파벳 대문자 E처럼 출력하기
     * 🌟🌟🌟
     * 🌟
     * 🌟🌟🌟
     * 🌟
     * 🌟🌟🌟
     */

    public void test7() {
        for (int i = 1; i <= 5; i++) {
            if(i % 2 != 0) {
                System.out.println("🌟🌟🌟");
            }
            else {
                System.out.println("🌟");
            }
        }
    }

    public void test71 () { // test7 예제코드 다른 에시
        for (int i = 0; i < 5; i++) {
            int limit = (i % 2 == 0) ? 3 : 1;
            for (int j = 0; j < limit; j++) {
                System.out.println("🌟");
            }
            System.out.println();
        }
    }


}
