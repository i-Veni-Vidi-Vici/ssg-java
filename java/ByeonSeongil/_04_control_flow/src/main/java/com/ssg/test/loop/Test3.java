package com.ssg.test.loop;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        if (!(num >= 1 && num <= 9)) {
            System.out.println("잘못 입력");
            return;
        }

        for (int i = 1; i < 9; i++) {
            System.out.printf("%d x %d = %d", num, i, num*i);
        }
    }
}
