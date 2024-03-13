package com.ssg.random.coin;

import java.util.Random;
import java.util.Scanner;

public class Game {
    public void flipCoin(){
        // 1~2 중에 입력받아 숫자 맞추기
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();

        int randomNum, num;

        while (true) {
            // 1 또는 2의 랜덤 수를 추출
            randomNum = rnd.nextInt(2) + 1;


            System.out.println("===동전 앞 뒤 맞추기===");
            // 사용자 앞뒷면 유추
            System.out.print("숫자를 입력해주세요 (1.앞면 / 2.뒷면) : ");
            num = sc.nextInt();

            if (randomNum == num){
                System.out.println();
                System.out.println("맞췄습니다^^");
                System.out.println("난수 : " + randomNum);
                System.out.println();
                System.out.println("--------->restart");
            }else{
                System.out.println();
                System.out.println("땡! 틀렸습니다.");
                System.out.println("난수 : " + randomNum);
                break;
            }
        }
    }
}
