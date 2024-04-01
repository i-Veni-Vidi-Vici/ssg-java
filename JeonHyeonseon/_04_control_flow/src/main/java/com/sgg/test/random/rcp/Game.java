package com.sgg.test.random.rcp;

import java.util.Random;
import java.util.Scanner;

public class Game {
    /**
     * 1. 프로그램 가위/바위/보 입력(난수)
     * 2. 사용자의 가위/바위/보 입력
     * 3. 값비교
     * 4. 결과 출력
     */
    public void rockPaperScissors() {
        Random rnd = new Random();
        Scanner sc = new Scanner(System.in);

        System.out.println("=== 가위 바위 보 게임 ===");
        System.out.print("숫자를 선택하세요(1.가위 / 2.바위 / 3. 보) : ");
        int comRcp = rnd.nextInt(3) + 1; // 컴퓨터 입력
        int userRcp = sc.nextInt(); // 사용자 입력

        // 값 비교
        String user = userRcp == 1 ? "가위" : (userRcp == 2 ? "바위" : "보");
        String com = comRcp == 1 ? "가위" : (comRcp == 2 ? "바위" : "보");

        System.out.println("========= 결과 ==========");
        System.out.println("당신은 " + user + "를 냈습니다.");
        System.out.println("컴퓨터는 " + com + "를 냈습니다.");
        System.out.println("========================");

        if(userRcp == comRcp) {
            System.out.println("비겼습니다.");
        } else if((comRcp == 1 && userRcp == 2) || (comRcp == 2 && userRcp == 3) || (comRcp == 3 && userRcp == 1)) {
            System.out.println("당신이 이겼습니다😢");
        } else {
            System.out.println("당신이 졌습니다😊");
        }
    }
}
