package com.sh.polymorphism._03._interface;

import java.io.Serializable;

/**
 * Serializable 객체입출력시에 필요한 인터페이스
 */
public class Computer extends Object implements IProduct, Serializable {

    @Override
    public void printInfo(){
        System.out.println("컴퓨터 상품입니다. 최대구매수량은 " + IProduct.MAX_NUM + "개 입니다.");
        // IProduct.MAX_NUM, MAX_NUM 와 같이 사용가능.
    }

    public void game(){
        System.out.println("게임을 시작합니다...");
    }
}
