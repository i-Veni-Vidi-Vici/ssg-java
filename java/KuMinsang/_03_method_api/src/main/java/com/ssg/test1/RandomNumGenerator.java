package com.ssg.test1;

import java.util.Random;

public class RandomNumGenerator {
    public void generate(){
        Random rnd = new Random();
        int tmp = rnd.nextInt(1000)+1;
        System.out.println("생성된 난수 : "+ tmp );
        if(300<=tmp && tmp<=600){
            System.out.println(" 300~600사이의 숫자입니다");
        }else{
            System.out.println(" 300~600사이의 숫자가 아닙니다");
        }
    }
}
