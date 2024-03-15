package com.ssg.test.loop;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        // 문제 3.
        Scanner sc = new Scanner(System.in);
        System.out.print("단수입력 : ");
        int dan = sc.nextInt();

        if(dan > 2 && dan < 10) {

            for (int i = 1; i <= 9; i++) {
                System.out.printf("%d * %d = %d\n", dan, i, dan * i);
            }
        }
        else {
            System.out.println("잘못입력하셨습니다. 프로그램종료합니다.");
        }
    }
}
