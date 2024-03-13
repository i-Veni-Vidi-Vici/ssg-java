package com.ssg.random.coin;

public class Main {
    public static void main(String[] args) {
        Game start = new Game();
        start.flipCoin();
        System.out.println("------------------------------> restart");
        start.flipCoin();
    }
}
