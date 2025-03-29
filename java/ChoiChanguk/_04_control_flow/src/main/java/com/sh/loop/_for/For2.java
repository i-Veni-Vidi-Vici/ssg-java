package com.sh.loop._for;


import java.util.Scanner;

public class For2 {

    public void test1(){
        /**
         * 중첩 반복문
         */
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                System.out.println("i값 = "+i+" j값 = "+j);
            }

        }
    }

    public void test2(){

        /**
         * 2~9단까지 구구단 출력
         */

        int i;
        int j;

        for(i=2;i<=9;i++)
        {
            System.out.println("\n "+i+"단");

            for(j=1;j<=9;j++)
            {
                //System.out.printf("%d * %d = %d\n",i,j,i*j);
                System.out.println(i+" * "+j+" = "+i*j);
            }
        }
    }

    public void test3()
    {
        /**
         * 중첩반복문 - 메소드를 이용
         */

        for(int dan=2;dan<10;dan++)
        {
            System.out.println("\n"+dan+"단 입니다");
            printEachDan(dan);
        }
    }
    public void printEachDan(int dan)
    {
        for(int i=1;i<10;i++)
        {
            System.out.printf("%d * %d = %d\n",dan,i,dan*i);
            //System.out.println(dan + " * "+i+" = "+dan*i);
        }
    }

    public void test4()
    {
        /***
         * 행/열 표시가 가능해짐
         */
        Scanner sc=new Scanner(System.in);
        System.out.print("몇행입니다? : ");
        int row=sc.nextInt();

        System.out.print("몇열입니다? : ");
        int col=sc.nextInt();

        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                System.out.printf("(%d . %d) ",i,j);
            }
            System.out.println("");
        }
    }

    public void test5()
    {
        /**
         * 사용자로부터 행/열 값을 입력 받아 별찍기 하세요
         */

        Scanner sc=new Scanner(System.in);
        System.out.print("몇행입니다? : ");
        int row=sc.nextInt();

        System.out.print("몇열입니다? : ");
        int col=sc.nextInt();

        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                System.out.printf("★ ");
            }
            System.out.println("");
        }
    }

    public void test6()
    {
        /**
         * 행수 입력 받아서
         * *
         * **
         * ***
         * **** 출력
         */
        Scanner sc =new Scanner(System.in);
        int n=sc.nextInt();

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<=i;j++)
            {
                System.out.printf("*");
            }
            System.out.println("");
        }
    }

    public void test7() {
        /** 형태로 출력
         * ㅁㅁㅁ
         * ㅁ
         * ㅁㅁㅁ
         * ㅁ
         * ㅁㅁㅁ
         */
        int i;
        int j;
        for(i=1;i<=5;i++)
        {
            if(i%2!=0)
            {
                for(j=0;j<3;j++)
                    System.out.printf("ㅁ");
            }
            else
            {
                System.out.printf("ㅁ");
            }
            System.out.println("");

        }
    }
}
