package com.ssg.random;

import java.util.Random;
import java.util.Scanner;

public class Game_Re {

    public void flipCoin() {
        Random rnd = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.println("=== 동전 앞 뒤 맞추기 ===");

        int comCoin = rnd.nextInt(2) + 1;

        System.out.print("숫자를 입력해주세요 (1. 앞면 / 2.뒷면) : ");
        int userCoin = sc.nextInt();
        String result = comCoin == userCoin ? "맞췄습니다^^" : "땡! 틀렸습니다!";
        System.out.println(result);
    }

}
