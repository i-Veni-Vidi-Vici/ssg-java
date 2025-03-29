package com.ssh.test.break_continue;

import java.util.Scanner;

public class Test1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("정수를 하나 입력하세요. => ");
        int n = sc.nextInt();
        long mul = 1;

        for (int i = 3; i <= n; i += 2) {
            mul *= i;
        }
        System.out.println("1부터 " + n + "까지 홀수의 곱은 " + mul + "입니다.");
    }
}
