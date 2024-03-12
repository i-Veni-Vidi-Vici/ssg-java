package com.ssg.random.coin;

import java.util.Random;
import java.util.Scanner;

public class Game {
    public void flipCoin() {
        Random rnd = new Random();
        int answer = rnd.nextInt(1,3);

        System.out.println("=== 동전 앞 뒤 맞추기 ===");
        // scanner 객체 생성
        Scanner sc = new Scanner(System.in);

        // 사용자 입력값을 읽어오기
        System.out.println("숫자를 입력해주세요 (1.앞면 / 2.뒷면)");
        int num = sc.nextInt();
//        System.out.println("입력한 숫자는 " + num);
        System.out.println(num == answer ? "맞췄습니다^^" + "\n ---------------> restart" : "땡! 틀렸습니다" );

    }
}
