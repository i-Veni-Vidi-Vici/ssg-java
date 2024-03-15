package com.ssg.test.break_continue;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("정수를 하나 입력하세요. =>");
        int num1 = sc.nextInt();
        System.out.print("다른 정수를 하나 입력하세요. =>");
        int num2 = sc.nextInt();

        int sum = 0;
        if (num1 > num2) {
            for (int i = num2; i <= num1; i++) {
                sum += i;
            }
            System.out.printf("%d부터 %d까지의 홀수의 합은 %d입니다.", num2, num1, sum);
        } else {
            for (int i = num1; i <= num2; i++) {
                sum += i;
            }
            System.out.printf("%d부터 %d까지의 홀수의 합은 %d입니다.", num1, num2,sum);
        }
    }
}
