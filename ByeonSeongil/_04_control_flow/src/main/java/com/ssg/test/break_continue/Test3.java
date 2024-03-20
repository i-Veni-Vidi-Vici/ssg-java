package com.ssg.test.break_continue;

import java.util.Random;
import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        int computer = random.nextInt(100) + 1;
        int user = 101;
        int count =0;

        while (computer != user) {
            System.out.print("정수 입력: ");
            user = sc.nextInt();
            if (computer > user) {
                System.out.println("입력하신 정수보다 큽니다.");
            } else if (computer < user) {
                System.out.println("입력하신 정수보다 작습니다.");
            }
            count++;
        }

        System.out.printf("정답입니다. %d회만에 정답을 맞추셨습니다.", count);
    }
}
