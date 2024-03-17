package com.sh.condition.loop._for;

import java.util.Scanner;

public class For2 extends For {
    /**
     * 중첩 반복문
     */
    public void test1()
    {
        for(int i = 0; i<3; i++)
        {
            System.out.println(i);

            for(int j = 1; j<=3; j++)
            {
                System.out.println("\t" + j);
            }
        }
    }
    //전체 구구단 출력
    public void test2()
    {
        for(int i = 2; i<=9; i++)
        {
            System.out.println("\t" + i + "단");
            for(int j = 1; j<=9; j++)
            {
                System.out.println(i + "*" + j + "=" + i*j );
            }
            System.out.println();
        }
    }

    /**
     * 중첩 반복문 - 메소드
     */
    public void test3()
    {
        for(int dan = 2; dan<=9; dan++)
        {
            System.out.println("\t" + dan + "단");
            printEachdan(dan);
            System.out.println();

        }
    }

    public void printEachdan(int dan)
    {
        for(int n = 1;n<=9 ;n++)
        {
            System.out.printf("%d * %d = %d\n", dan, n, dan*n);
        }
    }

    /**
     * 중첩 반복문 - 행/열 표현하기
     * - outer loop -> 행
     * - inner loop -> 열
     */

    public void test4()
    {
        //2행 3열
        for(int row = 0; row<2; row++) //행 반복문
        {
            for(int col = 0; col <3; col++ )
            {
                System.out.printf("(%d, %d)",row,col);
            }
            System.out.println();
        }
    }

    // 사용자로부터 행, 열 값을 입력 받아 별찍기 하세요
    // > 행 5, 열 : 3
    public void test5()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("행 :");
        int row = scanner.nextInt();
        System.out.println("열 :");
        int col = scanner.nextInt();

        for(int i = 0; i<row; i++)
        {
            for(int j = 0; j<col; j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // 행수를 입력 받아서 다음과 같이 출력
    // 행수 : 5
    public void test6()
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("행 수 :");
        int row = scan.nextInt();

        for(int i = 1; i<=row; i++)
        {
            for(int j = 1; j<=i ;j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    //4행 3열 (1-3),( 2-1) (3-3) (4-1) (5-3)
    public void test7()
    {
        for(int i = 1; i<=5; i++ )
        {
            if(i % 2 == 0)
            {
                for(int j = i ;j<i + 1; j++) System.out.print("ㅁ");
            }
            else{
                for(int j= i; j<= i+2; j++) System.out.print("ㅁ");
            }

            System.out.println();
        }
    }

    //public void test7()
    {
        for(int i = 0; i<5;i++)
        {
            int limit = (i%2 == 0) ? 3 : 1;
            for(int j = 0; j<limit; j++){
                System.out.println("ㅁ");
            }
            System.out.println();
        }
    }

}
