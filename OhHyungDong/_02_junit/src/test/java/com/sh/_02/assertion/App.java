package com.sh._02.assertion;

import java.util.Random;

public class App {
    public int getNumber() {

        return 0 ;
    }

    public int sum(int a, int b) {
        return a+b;
    }

    public int RandomNumber() {
        Random rnd = new Random();
        int n = rnd.nextInt(100) + 100;

        return n;
    }
}
