package com.ssg.random.coin;

import java.util.Random;
import java.util.Scanner;

public class Game {
    public void flipCoin(){
        Scanner sc = new Scanner(System.in);
        Random rnd=new Random();

        while(true)
        {
            int num= rnd.nextInt(2)+1;

            System.out.println("=== 동전 앞 뒤 맟주기====");

            System.out.print("숫자를 입력해주세요 (1.앞면/2.뒷면) :" );
            int coin = sc.nextInt();

            if(coin==num){
                System.out.println(" 맟췄습니다 ");
                return;
            }
            else
                System.out.println(" 땡 틀렸습니다! ");
        }

    }
}
