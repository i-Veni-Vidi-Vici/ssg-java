package com.ssh.test.loop;

import java.util.Scanner;

public class Test1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("정수 입력 : ");
        int n = sc.nextInt();
        long sum = 0;

        for (int i = 2; i <= n; i += 2) {
            sum += i;
        }
        System.out.println("1 ~ " + n + "까지의 모든 짝수들의 합 : " + sum);
    }
}
