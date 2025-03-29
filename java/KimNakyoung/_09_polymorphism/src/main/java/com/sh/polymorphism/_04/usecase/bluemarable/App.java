package com.sh.polymorphism._04.usecase.bluemarable;

public class App {
    public static void main(String[] args) {
        Player player = new Player();
        //1턴 - 이동
        int num = player.rollDice(new Dice6()); // 숫자 하나 받아 냄 포지션 숫자 (1~6)
        System.out.println("주사위 결과는 " + num + "이 나왔습니다...");
        player.move(num); // 이동

        //2턴 - 결투
        num = player.rollDice(new Dice2());
        System.out.println("결투 결과는 " + (num == 1 ? "승리"  : "패배"));
        if(num == 1) {
            num = player.rollDice(new Dice6());
            System.out.println("주사위 결과는 " + num + "이 나왔습니다...");
            player.move(num); // 이동
        }
    }
}
