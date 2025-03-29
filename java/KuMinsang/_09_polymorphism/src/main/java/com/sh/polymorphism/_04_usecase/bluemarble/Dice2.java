package com.sh.polymorphism._04_usecase.bluemarble;

public class Dice2 implements IDice{
    @Override
    public int getNumber() {
        return (int)(Math.random()*2)+1;
        //random mathod는 0.0 ~ 1.0 사이의 double 값 하나를 반환
        //2를 곱해서 0.0~2.0 사이의 값을 생성
        //1또는 2값 이므로 +1

    }
}
