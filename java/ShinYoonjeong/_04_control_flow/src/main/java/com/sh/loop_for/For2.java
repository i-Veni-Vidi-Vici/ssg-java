package com.sh.loop_for;

public class For2 {
    public void test1(){
        for(int i = 0;i<3;i++){
            System.out.println(i);
            for(int j=1;j<=5;j++)
            {
                System.out.println("\t" + j);
            }
        }
    }
    public void test2(){
        for(int i=2;i<10;i++){
            for(int j=1;j<10;j++){
                System.out.println(i + "*" + j + "=" + i*j);
            }
        }
    }
    public void test3(){
        for(int dan=2;dan<=9;dan++)
        {
            printEachDan(dan);
        }
    }
    public void printEachDan(int dan){
        for(int n=1;n<=9;n++){
            System.out.printf("%d * %d = %d\n", dan, n, dan*n);
        }
    }

    /**
     * 중첩반복문 - 행/열 표현하기
     * - outer loop -> 행
     * - inner loop -> 열
     *
     */
    public void test4(){
        // 2행 3열
        // 행
        for(int row = 0;row < 2;row++)
        {
            for(int col = 0;col < 3;col++)
            {
                System.out.print("☆ ");
            }
            System.out.println( ); // 개행처리
        }
    }
    public void test5()
    {
        for(int row = 0;row < 5;row++)
        {
            for(int col = 0;col < 3;col++)
            {
                System.out.print("☆ ");
            }
            System.out.println( ); // 개행처리
        }
    }
    public void test6(){
        for(int row = 6;row >1;row--)
        {
            for(int col = 0;col <= 6-row;col++)
            {
                System.out.print("☆");
            }
            System.out.println( ); // 개행처리
        }
    }
    public void test7(){
        for(int i=1;i<6;i++){
            if(i%2==0)
            {
                for(int j=0;j<1;j++)
                    System.out.print("☆");
            }
            else
            {
                for(int j=0;j<3;j++)
                    System.out.print("☆");

            }
            System.out.println(" ");
        }
    }
}
