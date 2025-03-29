package com.sh.loop._for;

import java.util.Scanner;

public class For2 {
    public void test1(){

    }

    public void test2(){
        // outer loop 2~9단
        for (int dan = 2; dan <= 9; dan++) {
            //inner loop 1~9
            System.out.printf("\t%d단\n",dan);
            for (int n = 1; n <= 9; n++) {
                System.out.printf("%d * %d = %d\n", dan, n, dan * n);
            }
            System.out.println();
        }
    }

    public void test3(){
        for (int dan = 2; dan <= 9; dan++) {
            //inner loop 1~9
            System.out.printf("\t%d단\n",dan);
            printEachDan(dan);
            System.out.println();
        }
    }

    public void printEachDan(int dan){
        for (int n = 1; n <= 9; n++) {
            System.out.printf("%d * %d = %d\n", dan, n, dan * n);
        }
    }

    /**
     * <pre>
     *     중첩 반복문 - 행/열 표현하기
     *     - outer loop -> 행
     *     - inner loop -> 열
     * </pre>
     */
    public void test4() {
        for (int row = 0; row < 2; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.printf("(%d,%d)\t",row,col);
            }
            System.out.println();
        }
    }

    /**
     * 사용자로부터 행렬 값을 입력 받아 별 찍기 하세요
     */
    public void test5() {
        Scanner sc = new Scanner(System.in);

        System.out.print("행을 입력하시오 : ");
        int row = sc.nextInt();
        System.out.print("열을 입력하시오 : ");
        int col = sc.nextInt();
        System.out.println();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("*\t");
            }
            System.out.println();
        }
    }
    public void test6() {
        Scanner sc = new Scanner(System.in);

        System.out.print("행을 입력하시오 : ");
        int row = sc.nextInt();

        for (int i = 0; i <= row; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*\t");
            }
            System.out.println();
        }
    }

    public void test7(){
        int limit = 0;
        for (int i = 0; i < 5; i++) {
            limit = (i % 2 == 0) ? 3 : 1;
            for (int j = 0; j < limit; j++) {
                System.out.print("□");
            }
            System.out.println();
        }
    }
}
