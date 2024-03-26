package com.sh.polymorphism._04.usercase.bluemarble;

public class Player {
    private int currentPosition;
    public void move(int num){
        this.currentPosition += num;
        System.out.println("Current Position: "+currentPosition);
    }
    public int rollDice(IDice dice){
        return dice.getNumber();
    }
}
