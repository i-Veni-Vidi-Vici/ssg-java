package com.sgg.test1;

import java.util.Random;

public class RandomGenerator {


    public void generate(){
        Random random = new Random();
        int ranNum = random.nextInt(1000);

        if (ranNum >= 300 && ranNum <= 600){
            System.out.println(ranNum);
            System.out.println("난수가 300 ~ 600사이에 포함 됩니다.");

        }
        else {
            System.out.println(ranNum);
            System.out.println("난수가 300~600 사이에 포함되지 않습니다.");
        }
    }


}

