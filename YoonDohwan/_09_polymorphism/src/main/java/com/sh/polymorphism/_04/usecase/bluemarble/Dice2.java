package com.sh.polymorphism._04.usecase.bluemarble;

public class Dice2 implements Idice{
    @Override
    public int getNumber() {
        return (int)(Math.random()*2);
    }
}
