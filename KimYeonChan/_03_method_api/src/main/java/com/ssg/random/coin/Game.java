package com.ssg.random.coin;

import java.util.Scanner;

public class Game {
    public void flipCoin() {
        Scanner sc = new Scanner(System.in);
        System.out.println("===동전 앞뒤 맞추기===");
        System.out.print("숫자 입력(1. 앞면 / 2. 뒷면): ");
        int playerChoice = sc.nextInt();
        int coinResult = (int)(Math.random() * 2) + 1;

        if (playerChoice == coinResult) {
            System.out.println("오! 맞췄습니다!");
        }
        else {
            System.out.println("땡! 틀렸습니다!!");
            System.out.println("---> Restart");
            flipCoin();
        }
    }
}
