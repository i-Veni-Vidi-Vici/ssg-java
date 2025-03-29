package com.ssg.test.random.rcp;

import java.util.Random;
import java.util.Scanner;

public class Game {
    void rockPaperScissors() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. 가위 2. 바위 3. 보 중 하나를 선택하세요 ");
        int choiceNumber = scanner.nextInt();
        Random random = new Random();
        int com = random.nextInt(3) + 1;

        String userNum = (choiceNumber == 1) ? "가위" : ((choiceNumber == 2) ? "바위" :"보");
        String comNum = (com == 1) ? "가위" : ((com == 2) ? "바위" : "보");

        System.out.println("당신은 " + userNum + "을 냈습니다");
        System.out.println("컴퓨터는" + comNum + "을 냈습니다");
        System.out.println("---------------------------------");

        if (choiceNumber == com) {
            System.out.println(" 당신은 비겼습니다");
        } else if ((choiceNumber == 1 && com == 3) || (choiceNumber == 2 && com == 1) || (choiceNumber == 3 && com == 2)) {
            System.out.println("당신이 이겼습니다");
        } else {
            System.out.println("당신이 졌습니다");


        }
    }
}
