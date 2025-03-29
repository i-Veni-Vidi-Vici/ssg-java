package com.sh._02.assertion;

import java.util.Random;

public class App {
    public int getNumber() {
        return 200;
    }

    public int sum(int a, int b) {
        return a + b;
    }

    public int random() {
//        Random rnd = new Random();
//        return rnd.nextInt(100) + 100;
        return (int) (Math.random() * 101) + 100;
    }
}
