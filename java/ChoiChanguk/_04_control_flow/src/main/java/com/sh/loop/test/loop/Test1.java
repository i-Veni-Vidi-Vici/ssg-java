package com.sh.loop.test.loop;

import java.util.Scanner;

public class Test1 {

    //요구사항 : 1부터 사용자로부터 입력 받은 정수까지
    //         존재하는 짝수의 합을 출력하세요.
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.printf("숫자를 입력 하세요 : ");

        int num=sc.nextInt();
        int sum=0;

        for(int i=1;i<=num;i++)
        {
            if(i%2==0)
                sum += i;
        }
        System.out.printf("sum = %d", sum);
    }
}
