package com.ssg.random.coin;

import java.util.Random;
import java.util.Scanner;

public class Game {
    public void flipCoin() {
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();

        System.out.println("===동전 앞 뒤 맞추기===");
        System.out.print("숫자를 입력해주세요 (1.앞면 / 2.뒷면) : ");

        int num = sc.nextInt(); // 입력받은 숫자
        int rndNum = rnd.nextInt(2) + 1;    // 동전 앞뒷면 (1 또는 2)의 난수 생성
        boolean isCorrect = (num == rndNum);   // 입력받은 숫자와 난수가 같으면 true, 다르면 false

        System.out.println();
        System.out.println(isCorrect==true ? "맞췄습니다^^" : "땡! 틀렸습니다!");

    }
}
