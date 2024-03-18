package com.ssg.test.break_continue;

import java.util.Scanner;

public class Test1 {

    /**
     * 정수 한 개를 입력 받아, 1부터 입력 받은 정수까지의 홀수의 곱을 출력하세요.
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 입력하세요.=> ");
        int num = sc.nextInt();

        long product = 1;

        for (int i = 1; i <= num; i++) {
            if (i % 2 == 0)
                continue;
            product *= i;
        }
        System.out.println(product);
    }

}