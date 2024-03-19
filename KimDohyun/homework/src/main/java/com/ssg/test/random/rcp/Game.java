package com.ssg.test.random.rcp;

import java.util.Random;

public class Game {
    public static void rockPaperScissors(int n) {
        System.out.println("======= 결과 =======");
        Random rand = new Random();
        int i = rand.nextInt(3) + 1;
        if(n == 1 && i == 2) System.out.println("당신은 가위를 냈습니다\n컴퓨터는 바위를 냈습니다.\n================\n당신이 졌습니다.ㅠ.ㅠ");
        if(n == 1 && i == 3) System.out.println("당신은 가위를 냈습니다\n컴퓨터는 보를 냈습니다.\n================\n당신이 이겼습니다.ㅠ.ㅠ");
        if(n == 2 && i == 1) System.out.println("당신은 바위를 냈습니다\n컴퓨터는 가위를 냈습니다.\n================\n당신이 이겼습니다.ㅠ.ㅠ");
        if(n == 2 && i == 3) System.out.println("당신은 바위를 냈습니다\n컴퓨터는 보를 냈습니다.\n================\n당신이 졌습니다.ㅠ.ㅠ");
        if(n == 3 && i == 1) System.out.println("당신은 보를 냈습니다\n컴퓨터는 가위를 냈습니다.\n================\n당신이 졌습니다.ㅠ.ㅠ");
        if(n == 3 && i == 2) System.out.println("당신은 보를 냈습니다\n컴퓨터는 바위를 냈습니다.\n================\n당신이 이겼습니다.ㅠ.ㅠ");

    }
}
