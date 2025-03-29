package com.ssg.random.coin;

import java.util.Random;
import java.util.Scanner;

public class Game {
    public void flipCoin() {
        Random rnd = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.println("===동전 앞 뒤 맞추기===");
        System.out.print("숫자를 입력해주세요(1.앞면 / 2.뒷면) : ");
        int coin = sc.nextInt();
        System.out.println();
        System.out.println(coin == (rnd.nextInt(2) + 1) ? "맞췄습니다^^" : "땡! 틀렸습니다!");
    }
}
