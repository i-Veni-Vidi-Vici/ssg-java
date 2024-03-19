package com.ssg.test.loop;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = 0;

        System.out.print("정수 입력 : ");
        num = sc.nextInt();

        for(int i = 1; i <= num; i++) {
            if(i % 2 == 1) {
                System.out.println("수");
            } else {
                System.out.println("박");
            }
        }

    }
}
