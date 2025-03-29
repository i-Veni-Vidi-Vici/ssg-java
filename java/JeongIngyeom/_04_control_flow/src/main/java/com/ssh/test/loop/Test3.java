package com.ssh.test.loop;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("단수 입력 : ");
            int n = sc.nextInt();

            if (n > 9 || n < 1) {
                System.out.println("잘못 입력하셨습니다. 프로그램을 종료합니다");
                break;
            }

            for (int i = 1; i < 10; i++) {
                System.out.printf("%d * %d = %d\n", n, i, n * i);
            }
            System.out.println();
        }
    }
}
