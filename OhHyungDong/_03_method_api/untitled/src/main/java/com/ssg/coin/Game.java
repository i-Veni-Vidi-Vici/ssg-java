package com.ssg.coin;

import java.util.Random;
import java.util.Scanner;

public class Game {

    public void flipCoin()
    {
        Scanner scan = new Scanner(System.in);
        Random rnd = new Random();
        int coinNumber = rnd.nextInt(2)  + 1;

        System.out.println("=====동전 앞 뒤 맞추기 =========");
        System.out.print("1.앞면 , 2. 뒷면 : ");

        int selectNumber = scan.nextInt();
        System.out.println(coinNumber);
        if(coinNumber == selectNumber) System.out.println("정답입니다");
        else System.out.println("틀렸습니다.");
    }
}
