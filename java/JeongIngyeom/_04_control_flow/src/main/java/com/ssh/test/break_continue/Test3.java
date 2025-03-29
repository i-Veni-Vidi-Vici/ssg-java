package com.ssh.test.break_continue;

import java.util.Scanner;

public class Test3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int randomNum = (int) (Math.random() * 100) + 1;
        int inputNum;
        int count = 0;

        while (true) {
            System.out.print("정수를 입력해주세요 : ");
            inputNum = sc.nextInt();
            count++;

            if (randomNum < inputNum) {
                System.out.println("입력하신 정수보다 작습니다.\n");
            } else if (randomNum > inputNum) {
                System.out.println("입력하신 정수보다 큽니다.\n");
            } else {
                System.out.println("정답입니다. " + count + "회 만에 정답을 맞추셨습니다.");
                break;
            }
        }

    }
}
