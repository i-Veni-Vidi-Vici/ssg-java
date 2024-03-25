package com.sh.polymorphism._04.usecase.bluemarable;

public class Dice2 implements IDice{

    @Override
    public int getNumber() {
        return (int) (Math.random()*2 ); // 0, 1
    }
}
