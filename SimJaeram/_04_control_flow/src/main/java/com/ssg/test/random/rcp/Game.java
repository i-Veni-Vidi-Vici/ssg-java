package com.ssg.test.random.rcp;

import java.util.Scanner;

public class Game {
    public void rockPaperScissors() {
        Scanner sc = new Scanner(System.in);
        int user = 0;
        int computer = 0;
        String result = "";

        System.out.println("=== 가위 바위 보 게임 ===");
        System.out.print("숫자를 선택하세요(1.가위 / 2.바위 / 3. 보) : ");
        user = sc.nextInt();
        computer =(int) (Math.random() * 3) + 1; // (int) (Math.random() * 경우의 수) + 최소값

        if(user == computer) {
            result = "비겼";
        } else {
            switch(user) {
                case 1:
                    switch(computer) {
                        case 2:
                            result = "졌";
                            break;
                        case 3:
                            result = "이겼";
                            break;
                    }
                break;

                case 2:
                    switch(computer) {
                        case 1:
                            result = "이겼";
                            break;
                        case 3:
                            result = "졌";
                            break;
                    }
                break;

                case 3:
                    switch(computer) {
                        case 1:
                            result = "졌";
                            break;
                        case 2:
                            result = "이겼";
                            break;
                    }
                break;

            }
        }

        System.out.println("======= 결과 =======");
        System.out.println("당신은 " + user + "를 냈습니다.");
        System.out.println("컴퓨터는 " + computer + "를 냈습니다.");
        System.out.println("===================");
        System.out.println("당신이 " + result + "습니다.");
    }
}
