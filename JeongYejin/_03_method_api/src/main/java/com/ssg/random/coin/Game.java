package com.ssg.random.coin;

import java.util.Random;
import java.util.Scanner;

public class Game {
    public void flipCoin() {
        System.out.println("===동전 앞 뒤 맞추기===");

        Random rnd = new Random();
        int num = (int)(Math.random()*2)+1;

        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요 (1.앞면 / 2.뒷면) : ");
        int input = sc.nextInt();

        System.out.println();
        System.out.println(num == input ? "맞췄습니다^^" : "땡! 틀렸습니다!");
        System.out.println();
    }
}
