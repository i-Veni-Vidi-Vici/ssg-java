package com.ssg.random;

import java.util.Random;
import java.util.Scanner;

public class Game {
    public void flipCoin() {
        Random rnd = new Random();
        Scanner scanner = new Scanner(System.in);
        int num = rnd.nextInt(2) + 1;

        System.out.println("=== 동전 앞 뒤 맞추기 ===");
        System.out.println("숫자를 입력해주세요. (1.앞면 / 2.뒷면)");
        int choice = scanner.nextInt();

        System.out.println(num == choice ? "맞췄습니다^^" : "땡! 틀렸습니다!");

    }
}
