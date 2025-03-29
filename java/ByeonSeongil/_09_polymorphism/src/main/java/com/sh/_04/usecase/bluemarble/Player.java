package com.sh._04.usecase.bluemarble;

public class Player {
    private int currentPosition;

    public void move(int num) {
        currentPosition += num;
        System.out.println("현재 위치: "+ currentPosition);
    }

    public int rollDice(IDice dice) {
        return dice.getNumber();
    }
}
