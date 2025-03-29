package com.ssg.test.break_continue;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rndNUm = (int)(Math.random() * 100) + 1;
        int playerNum;
        int tryCount = 0;
        while (true) {
            System.out.print("난수를 맞혀 보세요.: ");
            playerNum = sc.nextInt();
            if (playerNum > rndNUm) {
                System.out.println("입력하신 정수보다 작습니다.");
            }
            else if (playerNum == rndNUm) {
                System.out.println("정답입니다. " + tryCount + "회만에 맞추셨습니다.");
                break;
            }
            else {
                System.out.println("입력하신 정수보다 큽니다.");
            }
            tryCount++;
        }
    }
}
