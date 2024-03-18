package com.ssg.test.break_continue;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수 입력: ");
        int count = sc.nextInt();

        int sum = 1;
        for (int i = 1; i <= count; i++) {
            if (i % 2 == 0) {
                continue;
            }
            sum *= i;
        }

        System.out.println("홀수의 곱: "  + sum);
    }
}
