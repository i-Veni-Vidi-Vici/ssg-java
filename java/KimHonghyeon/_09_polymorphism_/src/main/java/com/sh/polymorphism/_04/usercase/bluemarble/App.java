package com.sh.polymorphism._04.usercase.bluemarble;

public class App {
    public static void main(String[] args) {
        Player player = new Player();
        Dice6 dice6 = new Dice6();
        Dice2 dice2 = new Dice2();

        int num = player.rollDice(dice6);
        System.out.println("roll dice result: "+ num);
        player.move(num);

        num = player.rollDice(dice2);
        System.out.println("fight result: " + (num==1 ? "Win" : "Lose"));


    }
}
