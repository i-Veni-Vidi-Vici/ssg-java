package com.ssg.test.break_continue;

import java.util.Scanner;

/**
 * 정수 한 개를 입력 받아, 1부터 입력 받은 정수까지의 홀수의 곱을 출력하세요.
 *
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수를 하나 입력하세요 =>");
        int num = sc.nextInt();
        int product = 1; // 곱셈은 초기화 1

        // for 초기식 에서도 초기화 1로 해야함
        for (int i = 1; i <= num; i++) {
            if (i % 2 != 0) {
                product *= i;
            }

        }System.out.println("1부터 " + num + "까지 홀수의 곱은 " + product + " 입니다");

    }
}
