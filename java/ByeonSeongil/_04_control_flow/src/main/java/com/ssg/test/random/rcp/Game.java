package com.ssg.test.random.rcp;

import java.util.Random;
import java.util.Scanner;

public class Game {
    public void rockPaperScissors() {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int computer = random.nextInt(3) + 1;
        System.out.println("===가위 바위 보 게임===");
        System.out.print("숫자를 선택하세요(1.가위/2.바위/3.보):");
        int user = sc.nextInt();

        System.out.println("======== 결과 ========");
        System.out.println(printResult("당신", user));
        System.out.println(printResult("컴퓨터", computer));
        System.out.println("=====================");

        if (computer == user) {
            System.out.println("비겼습니다.");
        } else if ((computer == 1 && user == 2)
                || (computer == 2 && user == 3)
                || (computer == 3 && user == 1)) {
            System.out.println("당신이 이겼습니다.");
        } else System.out.println("당신이 졌습니다.");
    }

    private String printResult(String name, int value) {
        StringBuilder builder = new StringBuilder(name);
        builder.append(": ");
        switch (value) {
            case 1:
                builder.append("가위");
                break;
            case 2:
                builder.append("바위");
                break;
            case 3:
                builder.append("보");
                break;
        }

        return builder.toString();
    }
}
