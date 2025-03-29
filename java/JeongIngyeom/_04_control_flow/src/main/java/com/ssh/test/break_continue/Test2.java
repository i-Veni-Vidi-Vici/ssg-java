package com.ssh.test.break_continue;

import java.util.Scanner;

public class Test2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("정수를 하나 입력하세요. => ");
        int min = sc.nextInt();
        System.out.print("다른 정수를 하나 입력하세요. => ");
        int max = sc.nextInt();

        if (min > max) {
            int temp = min;
            min = max;
            max = temp;
        }

        long sum = 0;
        for (int i = min; i <= max; i++) {
            if (i % 2 == 0) {
                continue;
            }

            sum += i;
        }
        System.out.println(min + "부터 " + max + "까지의 홀수의 합은 " + sum + "입니다.");
    }
}
