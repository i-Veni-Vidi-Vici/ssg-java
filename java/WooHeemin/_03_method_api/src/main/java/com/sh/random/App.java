package com.sh.random;

import java.util.Random;

public class App {
    public static void main(String[] args) {
        Random rnd = new Random();

        System.out.println((rnd.nextInt(10)) + 10);
        System.out.println((rnd.nextInt(256) - 128));
        System.out.println(rnd.nextInt(10, 15));

        int sum = 0;

        for(int i =0 ; i < 1000; ++i) {

            sum += rnd.nextInt(0,100);
        }

        System.out.println("Average" + sum / 1000);
    }
}
