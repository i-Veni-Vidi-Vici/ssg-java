package com.sh.polymorphism._04_usecase.bluemarble;

public class Player {
    private int currentPosition;

    public void move(int num){
        currentPosition += num;
    }

    public int rollDice(IDice dice){
        return dice.getNumber();
    }
}
