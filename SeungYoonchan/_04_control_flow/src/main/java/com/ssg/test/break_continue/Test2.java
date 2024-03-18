package com.ssg.test.break_continue;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자1를 입력하세요.=> ");
        int num1 = sc.nextInt();
        System.out.print("숫자2를 입력하세요.=> ");
        int num2 = sc.nextInt();

        int sum = 0;
        int big = 0, small = 0;
        if (num1 > num2) {
            big = num1;
            small = num2;
        } else {
            big = num2;
            small = num1;
        }

        for (int i = small; i <= big; i++) {
            if (i % 2 == 0)
                continue;
            sum += i;
        }

        System.out.printf("%d부터 %d까지의 홀수의 합은 %d입니다.", small, big, sum);
    }
}