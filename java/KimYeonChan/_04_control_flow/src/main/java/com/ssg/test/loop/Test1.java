package com.ssg.test.loop;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("1이상의 정수 입력: ");
        int count = sc.nextInt();

        int sum = 0;
        for (int i = 1; i <= count; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }

        System.out.println(sum);
    }
}
