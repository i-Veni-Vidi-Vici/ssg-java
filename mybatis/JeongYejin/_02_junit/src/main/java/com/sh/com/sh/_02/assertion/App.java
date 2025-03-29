package com.sh.com.sh._02.assertion;


import java.util.Random;

public class App {

    public int getNumber() {
        return 10;
    }

    public int sum(int a, int b) {
        return a + b;
    }

    public int random() {
        Random random = new Random();
        return random.nextInt(100) + 100;
    }
}
