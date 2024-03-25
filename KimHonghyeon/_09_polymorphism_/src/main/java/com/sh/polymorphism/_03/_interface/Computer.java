package com.sh.polymorphism._03._interface;


/**
 *  Serializable: 객체 입출력시 필요한 인터페이스
 */
public class Computer implements IProduct{

    @Override
    public void printInfo() {
        System.out.println("컴퓨터 상품입니다. 최대구매수량: " + IProduct.MAX_NUM);
    }
    public void game(){
        System.out.println("게임을 실행합니다.");
    }
}
