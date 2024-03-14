package com.ssg.test.random.rcp;

import java.util.Scanner;

public class Game {
    public void rockPaperScissors() {
        Scanner sc = new Scanner(System.in);
        System.out.println("===가위바위보 게임===");
        System.out.print("숫자를 선택하세요.(1. 가위 / 2. 바위 / 3. 보): ");
        int playerChoice = sc.nextInt();
        int computerChoice = (int)(Math.random() * 3) + 1;

        System.out.println("======결과======");
        switch (playerChoice) {
            case 1:
                System.out.println("당신은 가위를 냈습니다.");
                break;
            case 2:
                System.out.println("당신은 바위를 냈습니다.");
                break;
            case 3:
                System.out.println("당신은 보를 냈습니다.");
                break;
            default:
                System.out.println("잘못된 입력입니다.");
                return;
        }
        switch (computerChoice) {
            case 1:
                System.out.println("컴퓨터는 가위를 냈습니다.");
                break;
            case 2:
                System.out.println("컴퓨터는 바위를 냈습니다.");
                break;
            case 3:
                System.out.println("컴퓨터는 보를 냈습니다.");
                break;
        }

        // 1. 가위
        if (playerChoice == 1 && computerChoice == 3) {
            System.out.println("당신이 이겼습니다! 8ㅁ8");
        }
        else if (playerChoice == 1 && computerChoice == 1) {
            System.out.println("비겼군요! 0o0");
        }
        else if (playerChoice == 1 && computerChoice == 2) {
            System.out.println("제가 이겼습니다! *^^*");
        }
        // 2. 바위
        else if (playerChoice == 2 && computerChoice == 1) {
            System.out.println("당신이 이겼습니다! 8ㅁ8");
        }
        else if (playerChoice == 2 && computerChoice == 2) {
            System.out.println("비겼군요! 0o0");
        }
        else if (playerChoice == 2 && computerChoice == 3) {
            System.out.println("제가 이겼습니다! *^^*");
        }
        // 3. 보
        else if (playerChoice == 3 && computerChoice == 2) {
            System.out.println("당신이 이겼습니다! 8ㅁ8");
        }
        else if (playerChoice == 3 && computerChoice == 3) {
            System.out.println("비겼군요! 0o0");
        }
        else if (playerChoice == 3 && computerChoice == 1) {
            System.out.println("제가 이겼습니다! *^^*");
        }
    }
}
