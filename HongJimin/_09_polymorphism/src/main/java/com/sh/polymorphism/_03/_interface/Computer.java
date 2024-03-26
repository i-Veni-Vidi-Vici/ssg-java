package com.sh.polymorphism._03._interface;

import java.io.Serializable;

/**
 * Serializable 객체 입출력시에 필요한 인터페이스
 */
public class Computer implements IProduct, Serializable {
    @Override
    public void printInfo(){
        System.out.println("컴퓨터 상품입니다. 최대 구매 수량은 " + MAX_NUM + "개 입니다."); //부모 인터페이스의 있는 상수(MAX_NUM, IProduct.MAX_NUM 사용이 가능함!)
    }

    public void game() {
        System.out.println("게임을 시작합니다-!");
    }
}
