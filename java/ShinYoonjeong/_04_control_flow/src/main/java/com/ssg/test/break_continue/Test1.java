package com.ssg.test.break_continue;

import java.util.Scanner;

public class Test1 {
    public void test(){
        Scanner sc = new Scanner(System.in);
        System.out.println("정수를 입력하시오. => ");
        int num = sc.nextInt();
        int mul=1;
        for(int i=1;i<=num;i++)
        {
            if(i%2==1)
            {
                mul *= i;
            }
        }
        System.out.printf("1부터 %d까지의 홀수의 곱은 %d입니다.", num, mul);
    }
}
