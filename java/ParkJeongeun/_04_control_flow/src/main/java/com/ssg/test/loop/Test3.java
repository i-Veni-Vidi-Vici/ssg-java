package com.ssg.test.loop;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("> 단수 입력 : ");
        int dan = sc.nextInt();
        if (dan < 1 || dan > 9) {
            System.out.println("잘못 입력하셨습니다. 프로그램을 종료합니다.");
            return;
        }
        for (int i = 1; i < 10; i++) {
            System.out.printf("%d * %d = %d\n", dan, i, dan * i);
        }
    }
}
