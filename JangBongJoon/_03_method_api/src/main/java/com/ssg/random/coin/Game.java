package com.ssg.random.coin;

import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void flipCoin() {
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();
        //앞뒤 1,2만 나오게 난수 설정
        int coin = rnd.nextInt(2) + 1;
        //사용자에게 값을 받아오기
        int User = sc.nextInt();
        System.out.println("===동전 앞 뒤 맞추기====");
        System.out.println("숫자를 입력해주세요(1.앞면/2.뒷면): " + User);
        if (coin == User) {
            System.out.println("맞췄습니다!");
        } else System.out.println("땡 틀렸습니다!");
        System.out.println("----------------------> restart");
    }
}
