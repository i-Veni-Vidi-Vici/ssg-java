package com.ssg.random.coin;
import com.ssg.random.coin.Game;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.flipCoin();
        System.out.println("\n------------------------------------->restart");
        game.flipCoin();
    }
}
