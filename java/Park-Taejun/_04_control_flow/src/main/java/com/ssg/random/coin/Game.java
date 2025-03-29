package com.ssg.random.coin;

import java.util.Random;
import java.util.Scanner;

public class Game {
    public void flipCoin() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean continueGame = true;

        while (continueGame) {
            System.out.println("1. 앞면 /////// 2. 뒷면 선택하세요");
            int choice = scanner.nextInt();

            int ranNum = random.nextInt(2) + 1;
            System.out.println("ranNum의 값은 " + ranNum +"입니다.");

            if (choice == ranNum) {
                System.out.println("정답 입니다.");

            }else {
                System.out.println("틀렸습니다");
            }
            System.out.println("게임을 더 하시겠습니까 1.(예) 2.(아니요) ");

            int yes = scanner.nextInt();
            if(yes != 1){
                continueGame = false;

            }

        }
    }
}


