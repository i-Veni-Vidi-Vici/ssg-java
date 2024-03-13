package com.ssg.test2;

import java.util.Random;

public class App2 {

    public static void main(String[] args) {
        Random random = new Random();
        int ran = random.nextInt();
        if(ran % 2 == 0){
            System.out.println("짝수");
        }
        else System.out.println("홀수");
    }
}
