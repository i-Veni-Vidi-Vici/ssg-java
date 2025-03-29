package com.ssg.random.coin;

import java.util.Random;

public class Game {
    public  void flipCoin(int a){
        Random random = new Random();
        int answer = random.nextInt(2)+1;
        if(a == answer) System.out.println("맞췄습니다 ^^");
        else System.out.println("떙! 틀렸습니다 ^^");
    }
}
