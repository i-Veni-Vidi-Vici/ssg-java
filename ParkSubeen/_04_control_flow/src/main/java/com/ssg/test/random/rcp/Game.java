package com.ssg.test.random.rcp;

import java.util.Random;
import java.util.Scanner;

public class Game {
    public void rockPaperScissors() {
        Random rnd = new Random();
        Scanner sc = new Scanner(System.in);
        String rcp = "";
        String comRcp = "";

        System.out.println("===가위 바위 보 게임===");
        System.out.print("숫자를 선택하세요(1.가위/2.바위/3.보) : ");
        int rcpNum = sc.nextInt();
        int comRcpNum = rnd.nextInt(3) + 1;

        switch(rcpNum) {
            case 1: rcp = "가위"; break;
            case 2: rcp = "바위"; break;
            case 3: rcp = "보"; break;
            default:
                System.out.println("잘못 선택하였습니다. 다시 시작해주세요😥");
                return;
        }
        switch(comRcpNum) {
            case 1: comRcp = "가위"; break;
            case 2: comRcp = "바위"; break;
            default: comRcp = "보";
        }

        System.out.println("========결과========");
        System.out.println("당신은 " + rcp + "를 냈습니다.");
        System.out.println("컴퓨터는 " + comRcp + "를 냈습니다.");
        System.out.println("======================");

        int result = rcpNum - comRcpNum;
        switch(result) {
            case 0:
                System.out.println("무승부입니다!");
                break;
            case -1:
                System.out.println("컴퓨터가 이겼습니다! 😄😄😄");
                break;
            case -2:
                System.out.println("당신이 이겼습니다.. 😢😢😢");
                break;
            case 1:
                System.out.println("당신이 이겼습니다.. 😢😢😢");
                break;
            case 2:
                System.out.println("컴퓨터가 이겼습니다! 😄😄😄");
                break;
        }

    }
}
