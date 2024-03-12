package com.ssg.random.coin;

import java.util.Random;
import java.util.Scanner;

public class Game {
    public void flipCoin() {
        //Scanner 객체와 랜덤 난수 생성
        Scanner scannner = new Scanner(System.in);
        Random num = new Random();

        int coinSide = num.nextInt(1, 3);

        System.out.println("=== 동전 앞 뒤 맞추기 ===");
        System.out.println("숫자를 입력해주세요 (1. 앞면 / 2. 뒷면) : ");
        int usernum = scannner.nextInt();

        System.out.println((coinSide == usernum) ? :"맞췃습니다~~" : "틀렸습니다~");

    }


}
