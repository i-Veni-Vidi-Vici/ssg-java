package com.sh.polymorphism._04.usecase.bluemarble;

public class Player {
    private int currentPosition;

    public void move(int num) {
        currentPosition += num;
        System.out.println("플레이어의 현재 포지션은 " + currentPosition + "입니다.");
    }

    public int rollDice(IDice dice) {
        return dice.getNumber();
    }
}
