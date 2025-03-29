package com.sh.loop._for;

import java.awt.*;
import java.util.Scanner;

/**
 * 중첩반복문
 */
public class For2 {
    public void test1(){

    }
    public void test2(){
        //outerloop 2~9단 (8번)
        for(int dan = 2; dan <= 9; dan++){
            System.out.println("\t" + dan + "단");
            for(int n=1; n<=9 ; n++){
                System.out.printf("%d * %d = %d\n", dan, n, dan*n);
            }
            System.out.println();
        }
    }   //end of test2

    public void test3(){
        for(int dan = 2; dan <=9; dan++){
            printEachDan(dan);

        }
    }
    public void printEachDan(int dan){
        for(int n = 1; n<=9; n++){
            System.out.printf("%d * %d = %d\n", dan, n, dan * n);

        }
    }

    /**
     * 중첩 반복문 행/열 표현하기
     * -outer loop ->행
     * -inner loop ->열
     */
    public void test4(){
        //2행 3열
        for(int row = 0; row <2; row++){
            for(int col = 0; col<3; col++){
                System.out.printf("(%d, %d)", row, col);
            }
            System.out.println();
        }

    }

    public void test5(){
        Scanner sc = new Scanner(System.in);
        System.out.println("> 행 : ");
        int row = sc.nextInt();
        System.out.println("> 열 : ");
        int col = sc.nextInt();

        for(int i = 0; i<row; i++) {
            for (int j = 0; j<col; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }   //end of test5


    /**
     * 알파뱃 대문자 E처럼 출력하기
     * ㅇ ㅇ ㅇ
     * ㅇ
     * ㅇ ㅇ ㅇ
     * ㅇ
     * ㅇ ㅇ ㅇ
     */
    public void test7(){
        int j =0;
        for(int i = 0; i<5; i++){
            if(i%2==1)
                j = 1;
            else
                j = 3;
            for(int k=0; k<j; k++){
                System.out.print("O");
            }
            System.out.println();
        }
    }
}
