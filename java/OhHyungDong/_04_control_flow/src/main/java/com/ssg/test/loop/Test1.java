package com.ssg.test.loop;

import java.util.Scanner;

public class Test1
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("정수를 입력하세요 : ");
        int number = scanner.nextInt();
        int sum = 0;
        for(int i = 1; i<=number; i++)
        {
            if(i % 2 == 0) {
                sum += i;
            }
        }
        System.out.println("짝수 합 : " + sum);


    }
}
