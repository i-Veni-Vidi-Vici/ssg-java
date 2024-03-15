package com.ssg.random.coin;

import java.util.Scanner;

/**
 * 동전 앞 뒤 맞추기
 */

public class Game {
    public void flipCoin() {
        Scanner scanner = new Scanner(System.in);
        int userCoin;
        int randNum;

        // 게임 안내 메세지 출력
        System.out.println("=== 동전 앞 뒤 맞추기 ===");

        do {
            // 입력 안내 메세지 출력 및 사용자로부터 입력된 정수를 읽어들임
            System.out.print("숫자를 입력해주세요 (1. 앞면/ 2. 뒷면): ");
            userCoin = scanner.nextInt();

            // 1 또는 2의 난수 생성
            randNum = (int) (Math.random() * 2) + 1;

            // 생성된 난수와 사용자가 입력한 값 비교
            String result = (randNum == userCoin) ? "맞췄습니다^^" : "땡! 틀렸습니다!";

            // 결과 출력
            System.out.println(result);
            System.out.println();

            if(userCoin != -1)
                System.out.println("------------------------------------->restart");

        } while(userCoin != -1);
    }
}
