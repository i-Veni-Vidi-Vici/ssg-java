package com.sh.loop.test.loop;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("단수입력 : ");
        int dan=sc.nextInt();
        int i;
        int j;


        System.out.printf("\n%d단입니다\n",dan);

        if(dan<1&&dan>10) {
            System.out.printf("잘못입력하셨습니다, 프로그램을 종료 합니다");
        }
        else
        {
            for(i=1;i<=9;i++)
            {
                System.out.printf("%d * %d = %d\n",dan,i,i*dan);
            }
        }


    }
}
