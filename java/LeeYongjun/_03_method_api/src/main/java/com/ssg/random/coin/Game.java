package com.ssg.random.coin;

import java.util.Random;
import java.util.Scanner;


public class Game {
    public static void flipCoin() {
        Random random = new Random();
        int coinNum = random.nextInt(2)+ 1;
        System.out.println("===동전 앞 뒤 맟추기===");
        Scanner sc = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요(1.앞면/2.뒷면) : ");
        int usernum = sc.nextInt();
        String re = sc.next();

        if (usernum == coinNum) {
            System.out.println("맞았습니다^^");
        } else {
            System.out.println("땡! 틀렸습니다.!");
        }
    }
}


