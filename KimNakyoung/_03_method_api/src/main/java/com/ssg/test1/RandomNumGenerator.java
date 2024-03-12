package com.ssg.test1;


import java.util.Random;

/**
 * 기능제공 클래스
 *
 */

public class RandomNumGenerator {

    public void generate(){
//1. 1에서 1000사이의 정수범위의 난수를 생성
        Random rnd = new Random();
        int random = rnd.nextInt(1000) + 0;
        System.out.println(random);

        //        2. 난수출력, 생성된 난수가 300에서 600사이에 포함되는지 여부 출력
        System.out.println(random >= 300 && random <= 600 ? "포함" : "미포함");



    }

}
