package com.ssg.test.loop;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("입력 :");
        int num = sc.nextInt();

        for (int i = 1; i <= num ; i++) {
            if (i % 2 == 0) {
                System.out.println("박");
            } else System.out.println("수");
        }
    }
}
