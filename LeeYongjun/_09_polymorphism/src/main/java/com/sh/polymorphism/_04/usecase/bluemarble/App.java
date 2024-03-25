package com.sh.polymorphism._04.usecase.bluemarble;

public class App {
    public static void main(String[] args) {
        Player player = new Player();
        // 1턴
        int num = player.rollDice(new Dice6());
        System.out.println("주사위 결과는 " + num + "이 나왔습니다...");
        player.move(num);
        // 2턴 - 결투
        num = player.rollDice(new Dice2());
        System.out.println("결투 결과는" + (num == 1 ? "승리" : "패배") + "입니다...");
        if(num ==1){
            //승리했을때 코드
            num = player.rollDice(new Dice6());
            System.out.println("주사위 결과는 " + num +"이 나왔습니다...");
            player.move(num);
        }
    }
}
