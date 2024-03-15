package com.ssg.test.random.rcp;

import java.util.Scanner;

public class Game {
    public void rockPaperScissors() {
        Scanner sc = new Scanner(System.in);


        System.out.println("=======가위 바위 보 게임=======");
        System.out.print("숫자를 선택하세요(1.가위/2.바위/3.보) : ");
        int num = sc.nextInt();
        System.out.println("=============결과=============");

        // 사람 입력결과
        String person = " ";
        switch (num) {
            case 1:
                person = "가위";
                break;
            case 2:
                person = "바위";
                break;
            case 3:
                person = "보";
                break;
        }

        // 컴퓨터 랜덤결과
        int rnd = (int) (Math.random() * 3) + 1;
        String computer = " ";
        switch (rnd) {
            case 1:
                computer = "가위";
                break;
            case 2:
                computer = "바위";
                break;
            case 3:
                computer = "보";
                break;
        }

        // 결과 출력
        System.out.println("당신은 " + person + "를 냈습니다.");
        System.out.println("컴퓨터는 " + computer + "를 냈습니다.");
        System.out.println("=============================");

        if (num == 1 && rnd == 2) {
            System.out.println("당신이 졌습니다. ㅠ.ㅠ");
        } else if (num == 1 && rnd == 3) {
            System.out.println("당신이 이겼습니다!");
        } else if (num == 2 && rnd == 1) {
            System.out.println("당신이 이겼습니다!");
        } else if (num == 2 && rnd == 3) {
            System.out.println("당신이 졌습니다. ㅠ.ㅠ");
        } else if (num == 3 && rnd == 1) {
            System.out.println("당신이 졌습니다. ㅠ.ㅠ");
        } else if (num == 3 && rnd == 2) {
            System.out.println("당신이 이겼습니다!");
        } else {
            System.out.println("비겼습니다.");
        }
    }
}
