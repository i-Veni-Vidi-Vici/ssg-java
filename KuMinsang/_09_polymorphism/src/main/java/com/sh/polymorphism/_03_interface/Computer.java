package com.sh.polymorphism._03_interface;

import java.io.Serializable;

/**
 * Serializable 객체 입출력시에 필요한 인터페이스
 *
 */
public class Computer implements IProduct, Serializable {

    @Override
    public void printInfo() {
        System.out.println("컴퓨터 상품입니다. 최대 구매수량은 "+ MAX_NUM+"개 입니다.");
    }
    public void game(){
        System.out.println("게임을 시작합니다");
    }
}
