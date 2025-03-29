package com.ssg.test.break_continue;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.printf("정수를 입력해주세요 : " );
        int num=sc.nextInt();
        int multi=1;

        int i;

        for(i=1;i<=num;i++)
        {
            if(i%2==0)
            {
                continue;
            }
            else{
                multi*=i;
            }
        }
        System.out.print(multi);
    }
}
