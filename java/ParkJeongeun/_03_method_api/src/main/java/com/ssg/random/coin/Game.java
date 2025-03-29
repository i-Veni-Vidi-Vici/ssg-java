package com.ssg.random.coin;

import java.util.Scanner;

public class Game {

    public void flipCoin() {
        int rnd = (int) (Math.random() * 2) + 1;
        Scanner sc = new Scanner(System.in);

        System.out.println("=== 동전 앞 뒤 맞추기 ===");
        System.out.print("숫자를 입력해주세요 (1.앞면 / 2.뒷면) : ");
        int side = sc.nextInt();
        System.out.println();
        System.out.println((rnd == side) ? "맞췄습니다^^" : "땡! 틀렸습니다!");
        System.out.println();
        System.out.println("----------------------------->restart");
        flipCoin();
    }
}
