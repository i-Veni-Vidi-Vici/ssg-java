package com.ssg;

import java.util.Random;

public class app4 {


    public static void main(String[] args) {
        Random rand = new Random();
        int a;
        if((a = rand.nextInt()) % 2 == 0) System.out.println(a + " 짝수");
        else System.out.println(a + "홀수");;

    }

}
