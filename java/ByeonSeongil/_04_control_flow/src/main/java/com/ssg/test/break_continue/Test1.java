package com.ssg.test.break_continue;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("정수 입력: ");
        int numeber = sc.nextInt();
        int result =1;
        for (int i = 1; i <= numeber; i+=2) {
            result *= i;
        }
        System.out.printf("1부터 %d까지 홀수의 곱 %d", numeber, result);
    }
}
