package com.sh.loop._for;

public class For2 {
    public void test1() {
        //
    }
    public void test2() {
        for (int i = 2; i <= 9 ; i++) {

            for (int j = 1; j <= 9 ; j++) {
                System.out.printf("%d * %d = %d\n", i, j, i * j);
            }
            System.out.println("===========");
        }
    }
    /**
     * 중첩 반복문 - 메소드
     */
    public void test3() {
        for (int dan = 2; dan <= 9; dan++) {
            printEachDan(dan);
        }
    }
    public void printEachDan(int dan) {
        for (int i = 1; i <=9; i++) {
            System.out.printf("%d * %d = %d\n", dan, i, dan * i);
        }
    }
    /**
     * 중첩반복문 - 행/열 표현하기
     * - outer loop -> 행
     * - inner loop -> 열
     */
    public void test4() {
        for (int row = 0; row < 2; row++) {
            // 열
            for (int col = 0; col < 3; col++) {
                System.out.printf("(%d, %d)", row, col);
            }
            System.out.println();
        }
    }
    public void test5() {
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print("⭐️");
            }
            System.out.println();
        }
    }
    public void test6() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print("⭐️");
            }
            System.out.println();
        }
    }
    public void test7() {
        for (int i = 0; i < 5; i++) {
            int limit = (i % 2 == 0) ? 3: 1;
            for (int j = 0; j < limit; j++) {
                System.out.print("⭐️");
            }
            System.out.println();
        }
    }
}
