package com.ssg.random.coin;

import java.util.Random;
import java.util.Scanner;

public class Game {
    public void flipCoin(){
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();
        int scan;
        int num;

        while(true){
            System.out.println("======= 동전 앞 뒤 맞추기 =======");
            System.out.print("숫자를 입력해주세요 ( 1. 앞면 / 2. 뒷면 ) : ");
            scan = sc.nextInt();

            num = rnd.nextInt(2) + 1;
            System.out.println("난수 : " + num);

            String result = (scan == num ? "정답" : "오답");
            System.out.println(result);
            if(result == "정답")
                return;
        }

    }
}
