package com.sh.loop._for;

import java.sql.SQLOutput;
import java.util.Scanner;

public class For2 {
    public void test1(){
        for(int i =0; i<3; i++){
            System.out.println(i);
            for(int j =0; j<5; j++){
                System.out.println("\t" + j);
            }
        }
    }
    public void test2(){
        for(int i=1; i<=9; i++){
            System.out.println(i+"단");
            for(int j = 1; j<=9; j++){
                System.out.printf("%d * %d = %d\n", i,j,i*j);
            }
            System.out.println("---------------");
        }
    }

    public void test3(){
        for(int dan = 2; dan<=9; dan++){
            printEachDan(dan);
            System.out.println();
        }
    }

    public void printEachDan(int dan){
        for(int n =1; n<=9;n++){
            System.out.printf("%d * %d = %d\n", dan, n, dan*n);
        }
    }

    public void test4(){
        for(int row =0; row<2; row++){
            for(int col=0; col<3; col++){
                System.out.printf("(%d, %d) ",row, col);
            }
            System.out.println();
        }
    }

    public void test5(){
        Scanner scanner  = new Scanner(System.in);
        int row, col;
        System.out.println("행의 개수를 입력하세요: ");
        row = scanner.nextInt();
        System.out.println("열의 개수를 입력하세요: ");
        col = scanner.nextInt();
        for(int i =0; i<row; i++){
            for(int j =0; j<col;j++){
                System.out.printf("◆ ");
            }
            System.out.println();
        }

    }
    public void test6(){
        Scanner scanner  = new Scanner(System.in);
        System.out.println("행의 개수를 입력하세요: ");
        int row = scanner.nextInt();
        for(int i = 0; i<row; i++){
            for(int j = 0; j<i+1; j++){
                System.out.printf("★");
            }
            System.out.println();
        }

    }

    public void test7(){
        for(int i = 0; i< 5; i++){
            if(i%2==0){
                for(int j =0; j<3; j++){
                    System.out.printf("□");
                }
                System.out.println();
            }
            else{
                System.out.printf("□");
                System.out.println();
            }
        }
    }
}
