package com.ssg.test.loop;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("구구단 몇 단? : ");
        int userNum = sc.nextInt();

        while (userNum>=1 && userNum <=9) {
            for (int i = 1; i <10; i++) {
                System.out.println(userNum + " * " + i + " = " + userNum*i);
            }
        }
        System.out.println("잘못 입력했어! 프로그램 종료할게!");

    }
}
