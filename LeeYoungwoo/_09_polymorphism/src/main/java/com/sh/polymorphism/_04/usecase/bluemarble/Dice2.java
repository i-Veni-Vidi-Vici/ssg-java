package com.sh.polymorphism._04.usecase.bluemarble;

import java.util.Random;

public class Dice2 implements IDice {
    @Override
    public int getNumber() {
        return (int) (Math.random() * 2); // 0, 1
    }
}
