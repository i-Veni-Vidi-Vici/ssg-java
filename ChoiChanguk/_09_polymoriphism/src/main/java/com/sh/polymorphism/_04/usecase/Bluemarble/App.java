package com.sh.polymorphism._04.usecase.Bluemarble;

public class App {
    public static void main(String[] args) {
        Player player = new Player();
        //1턴
        int num = player.rollDice(new Dice6());
        System.out.println("주사위 결과는 : " + num + "입니다");
        player.move(num);

        //2턴 - 결투
        num = player.rollDice(new Dice2());
        System.out.println("결투 결과는 : " + (num == 1 ? "승리" : "패배"));
        if (num == 1) {
            //승리 했을 때 코드
            num = player.rollDice(new Dice6());
            System.out.println("주사위 결과는 : " + num + "입니다");
            player.move(num);
        }
    }
}
