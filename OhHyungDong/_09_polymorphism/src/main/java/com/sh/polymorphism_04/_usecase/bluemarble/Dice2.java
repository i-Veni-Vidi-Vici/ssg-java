package com.sh.polymorphism_04._usecase.bluemarble;

public class Dice2 implements IDice{
    @Override
    public int getNumber() {
        return (int) Math.random() * 2 ;
    }
}
