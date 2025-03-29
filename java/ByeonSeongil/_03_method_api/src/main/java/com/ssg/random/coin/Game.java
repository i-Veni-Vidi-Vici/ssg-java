package com.ssg.random.coin;

import java.util.Random;
import java.util.Scanner;

public class Game {
    public void flipCoin() {
        Random random = new Random();
        boolean isRunning = true;
        while (isRunning) {
            int value = random.nextInt(2) + 1;

            Scanner scanner = new Scanner(System.in);
            System.out.println("=== 동전 앞 뒤 맞추기 ===");
            System.out.print("숫자를 입력해주세요 (1.앞면 /2.뒷면): ");
            int input = scanner.nextInt();

            if (value == input) {
                System.out.println("맞췄습니다^^");
            } else System.out.println("땡! 틀렸습니다!");

            System.out.print("--------------->(입력: restart/quit)");
            String game = scanner.next();

            if (game.equals("restart")) {
                isRunning = true;
            }
            if (game.equals("quit")) {
                isRunning = false;
            } else throw new IllegalArgumentException("잘못된 입력값 입니다.");
        }

    }
}

