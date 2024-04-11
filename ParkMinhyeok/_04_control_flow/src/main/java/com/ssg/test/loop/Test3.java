package com.ssg.test.loop;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("단수 입력: ");
        int dan = sc.nextInt();

        for (int i = 1; i <= 9; i++) {
            System.out.println(dan + " * " + i + " = " + dan * i);
            if (dan > 9) {
                System.out.println("잘못입력하셨습니다. 프로그램을 종료합니다");
                break;
            }
        }
    }
}
