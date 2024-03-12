package com.ssg.random.coin;

import java.util.Scanner;

public class Game {
    public static void flipCoin() {
        Scanner sc = new Scanner(System.in);
        String num = sc.next();
        boolean isCorrect = num=="1" && num=="2";

        System.out.println("===동전 앞 뒤 맞추기===");
        System.out.println("숫자를 입력해주세요 (1.앞면 / 2.뒷면) : " + num);

    }
}
