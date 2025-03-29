package com.ssg.test.random.rcp;

import java.util.Random;
import java.util.Scanner;

public class Game {
    public void rockPaperScissors() {
        System.out.println("=== 가위 바위 보 게임 ===");

        // 사용자 가위 바위 보 선택
        Scanner sc = new Scanner(System.in);
        System.out.println("숫자를 선택하세요 (1.가위 / 2.바위 / 3.보) : ");
        int userNum = sc.nextInt();

        // 컴퓨터 가위 바위 보 선택
        Random rnd = new Random();
        int comNum = rnd.nextInt(1, 4);

        // 사용자와 컴퓨터의 int값을 가위 바위 보로 변경
        String userChoice = "";
        String comChoice = "";

        switch (userNum) {
            case 1 : userChoice = "가위"; break;
            case 2 : userChoice = "바위"; break;
            case 3 : userChoice = "보"; break;
            default:
                System.out.println("다시 입력해주세요.");
                return;
        }

        switch (comNum) {
            case 1 : comChoice = "가위"; break;
            case 2 : comChoice = "바위"; break;
            case 3 : comChoice = "보"; break;
        }

        // 결과
        System.out.println("======== 결과 ========");

        System.out.println("당신은 " + userChoice + "를 냈습니다.");
        System.out.println("컴퓨터는 " + comChoice + "를 냈습니다.");

        String result;
        if (userNum - comNum == -1 || userNum - comNum == 2) {
            result = "패배";
        }
        else if (userNum - comNum == 0) {
            result = "무승부";
        }
        else {
            result = "승리";
        }
        System.out.println("========================");
        System.out.println("당신의 결과는 " + result + "입니다.");
    }
}
