package com.sh.polymorphism._03._interface;

public class Computer implements IProduct{
    @Override
    public void printInfo() {
        System.out.println("컴퓨터 상품입니다. 최대 구매 수량은 " + MAX_NUM + "개 입니다.");
        // IProduct.MAX_NUM, MAX_NUM 와 같이 사용 가능.
    }

    public void game() {
        System.out.println("게임 중...");
    }
}
