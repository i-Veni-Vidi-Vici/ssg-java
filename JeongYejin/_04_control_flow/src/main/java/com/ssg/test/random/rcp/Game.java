package com.ssg.test.random.rcp;

import java.util.Random;
import java.util.Scanner;

public class Game {
    public void rockPaperScissors() {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== 가위 바위 보 게임 ===");
        System.out.println("숫자를 선택하세요(1.가위 / 2.바위 / 3.보) : ");
        int userNum = sc.nextInt();
        Random rnd = new Random();
        int computerNum = rnd.nextInt(3)+1;

        System.out.println("======== 결과 ========");
        switch (userNum) {
            case 1 :
                System.out.println("당신은 가위를 냈습니다.");
                break;
            case 2 :
                System.out.println("당신은 바위를 냈습니다.");
                break;
            case 3 :
                System.out.println("당신은 보를 냈습니다.");
                break;
        }
        switch (computerNum) {
            case 1 :
                System.out.println("컴퓨터는 가위를 냈습니다.");
                break;
            case 2 :
                System.out.println("컴퓨터는 바위를 냈습니다.");
                break;
            case 3 :
                System.out.println("컴퓨터는 보를 냈습니다.");
                break;
        }

        System.out.println("=======================");

        if (userNum == computerNum) {
            System.out.println("비겼습니다~");
        } else if (userNum - computerNum == 1 || userNum - computerNum == -2) {
            System.out.println("당신이 이겼습니다!");
        } else {
            System.out.println("컴퓨터가 이겼습니다!");
        }
    }
}
