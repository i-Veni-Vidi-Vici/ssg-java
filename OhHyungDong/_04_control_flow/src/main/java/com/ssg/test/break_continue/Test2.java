package com.ssg.test.break_continue;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);

        System.out.println("정수를 하나 입력하세요(작은값)  :");
        int n1 = scanner.nextInt();// 작은수
        System.out.println("정수를 하나 입력하세요(큰값)  :");
        int n2 = scanner.nextInt(); //큰수
        int sum = 0;

        for(int i = n1; i<=n2; i++)
        {
            if(i % 2 == 1)
            {
                sum += i;
            }
            else continue;
        }
        System.out.println(n1 + " 부터 " + n2 + "까지의 합은 " + sum +"입니다.");
    }

}
