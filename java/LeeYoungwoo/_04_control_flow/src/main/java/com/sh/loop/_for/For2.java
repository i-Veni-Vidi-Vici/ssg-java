package com.sh.loop._for;

import java.util.Scanner;

/**
 * 중첩반복문
 */
public class For2 {
    public void test1() {
        for(int i = 0; i < 3; i++) {
            System.out.println(i);

            for(int j = 1; j <= 3; j++){
                System.out.println("\t" + j);
            }

        }
    }

    /**
     * 전체 구구단 출력
     */
    public void test2() {
        // outer loop 2단 ~ 9단 (8번 반복)
        for(int dan = 2; dan <= 9; dan++) {
            System.out.println("\t" + dan + "단");
        // inner loop 1 ~ 9 (9번 반복)
            for(int i = 1; i < 10; i++) {
                System.out.println(dan + " * " + i + " = " + (dan * i) );
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
        System.out.println("----" + dan + "단----");
        for(int n = 1; n <= 9; n++){
            System.out.printf("%d * %d = %d\n" , dan, n, dan * n);
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
        for(int row = 0; row < 2; row++) {
        // 열
            for(int col = 0; col < 3; col++) {
//                System.out.print("🧶");
                System.out.printf("(%d, %d)" , row, col);
            }
            System.out.println(); // 개행처리
        }
    }

    /**
     * 사용자로부터 행/열 값을 입력 받아 별찍기하세요.
     * > 행 : 5
     * > 열 : 3
     * 결과
     * ★★★
     * ★★★
     * ★★★
     * ★★★
     * ★★★
     *
     */
    public void test5() {
        Scanner sc = new Scanner(System.in);
        System.out.println("> 행 : ");
        int rowNum = sc.nextInt();
        System.out.println("> 열 : ");
        int colNum = sc.nextInt();

        for(int row = 1; row <= rowNum; row++) {

            for(int col =1; col <= colNum; col++) {
                System.out.printf("%s" , "★");
            }
            System.out.println();
        }
    }

    /**
     * 행 수를 입력받아서 다음과 같이 출력
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
        int colNum = sc.nextInt();

        for(int col = 1; col <= colNum; col++) {
//            System.out.println(col);
            for(int star = 1; star <= col; star++) {
//                System.out.printf("%s", "★");
                System.out.print("★");
            }
            System.out.println();
        }
    }


    /**
     * 알파벳 대문자 E처럼 출력하기
     * □ □ □
     * □
     * □ □ □
     * □
     * □ □ □
     */
    public void test7() {
        for(int i = 1; i <=5; i++) {
            if(i % 2 == 0) {
                System.out.println("□");
            }
            else {
                for(int s = 0; s < 3; s++){
                    System.out.print("□ ");
                }
                System.out.println();
//                System.out.println("□ □ □");
            }
        }
    }
}
