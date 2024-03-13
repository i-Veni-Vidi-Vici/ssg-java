package com.ssg.test1;
import java.util.Random;

public class RandomNumGenerator {
        public void generate(){
            Random rnd = new Random();
            // 1에서 1000사이의 정수범위의 난수를 생성
            int randomNum = rnd.nextInt(1000) + 1;
            System.out.println("생성된 난수 : " + randomNum);
            System.out.println(randomNum>=300 && randomNum<=600? randomNum + "은 300~600에 포함된다": randomNum + "은 300~600에 포함되지 않는다");
        }
    }
