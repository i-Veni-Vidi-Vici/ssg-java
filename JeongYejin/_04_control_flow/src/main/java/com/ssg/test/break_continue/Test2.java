package com.ssg.test.break_continue;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Test2 test2 = new Test2();
        test2.test();
    }

    private void test() {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수를 하나 입력하세요. => ");
        int num1 = sc.nextInt();
        System.out.print("다른 정수를 하나 입력하세요. => ");
        int num2 = sc.nextInt();
        int max = Math.max(num1, num2);
        int min = Math.min(num1, num2);
        int sum = 0;
        for (int i = min; i <= max; i++) {
            if (i % 2 == 1) {
                sum += i;
            } else {
                continue;
            }
        }
        System.out.printf("%d부터 %d까지의 홀수의 합은 %d입니다.", min, max, sum);
    }
}
