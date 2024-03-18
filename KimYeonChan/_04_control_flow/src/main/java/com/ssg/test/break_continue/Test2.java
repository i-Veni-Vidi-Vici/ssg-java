package com.ssg.test.break_continue;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수1 입력: ");
        int count1 = sc.nextInt();
        System.out.print("정수2 입력: ");
        int count2 = sc.nextInt();

        if (count1 < count2) {
            int tmp = count1;
            count1 = count2;
            count2 = tmp;
        }

        int sum = 0;
        for (int i = count2; i <= count1; i++) {
            if (i % 2 == 0) {
                continue;
            }
            sum += i;
        }

        System.out.println("홀수의 곱: "  + sum);
    }
}
