package com.ssg.random.coin;

import java.util.Random;
import java.util.Scanner;

/**
 *
 *
 * 동전 앞 뒤 맞추기 (팀 과제)
 * 1또는 2의 랜덤 수를 추출 한 뒤 사용자가 입력한 값과 비교
 * === 동전 앞 뒤 맞추기 ===
 * 숫자를 입력해주세요 (1.앞면 / 2.뒷면) : 1
 *
 * 맞췄습니다^^
 *
 * ----------------------->restart
 * 숫자를 입력해주세요(1.앞면 / 2. 뒷면) : 1
 *
 * 땡! 틀렸습니다!
 * 기능제공 클래스
 *
 */
public class Game {
    public void flipCoin() {
        Random rnd = new Random();
        Scanner sc = new Scanner(System.in);


        System.out.println("=== 동전 앞 뒤 맞추기 ===");
        while (true){

            int random = rnd.nextInt(2) + 1; // 1또는 2의 랜덤 수를 추출

            System.out.print("숫자를 입력해주세요 (1.앞면 / 2.뒷면) : " );
            int num = sc.nextInt(); //사용자 입력

            //사용자가 입력한 값과 비교
            if(num == random) {
                System.out.println();
                System.out.println("맞췄습니다^^");
                System.out.println();
                System.out.println("--------->restart");
            }else {
                System.out.println();
                System.out.println("땡! 틀렸습니다.");
                break;
            }

        }
    }
}
