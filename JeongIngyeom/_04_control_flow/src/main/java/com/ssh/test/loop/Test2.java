package com.ssh.test.loop;

import java.util.Scanner;

public class Test2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("정수 입력 : ");
        int n = sc.nextInt();
        char c;

        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                c = '박';
            } else {
                c = '수';
            }
            System.out.print(c);
        }
        System.out.println();
    }
}
