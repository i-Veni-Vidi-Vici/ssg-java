package com.sh.polymorphism._04._usecase.bluemarble;

public class Dice2 implements IDice { // 0또는 1을 줌
    @Override
    public int getNumber() {
        return (int) (Math.random() * 2); // 0, 1 임
    }
}
