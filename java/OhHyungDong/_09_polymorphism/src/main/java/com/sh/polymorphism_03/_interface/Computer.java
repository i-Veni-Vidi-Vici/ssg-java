package com.sh.polymorphism_03._interface;

import java.io.Serializable;

/**
 * Serializable : 객체 입출력시에 필요한 인터페이스
 * extends 클래스 1개만 implements(구현) 여러개가 가능하다.
 */
public class Computer implements IProduct, Serializable {
    @Override
    public void getInfo() {
        System.out.println("컴퓨터 상품입니다. 최대 구매수량은 " + IProduct.MAX_VALUE+"개 입니다.");
    }

    public void game(){
        System.out.println("게임을 시작합니다 ");
    }
}
