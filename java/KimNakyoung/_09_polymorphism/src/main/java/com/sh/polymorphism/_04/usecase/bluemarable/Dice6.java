package com.sh.polymorphism._04.usecase.bluemarable;

public class Dice6 implements IDice {

    @Override
    public int getNumber() {
        return (int) (Math.random()*6) + 1 ;
    }
}
