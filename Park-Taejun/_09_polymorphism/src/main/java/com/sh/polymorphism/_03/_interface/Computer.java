package com.sh.polymorphism._03._interface;

/**
 * Serializable 객체입출력시에 필요한 인터페이스
 */

public class Computer implements IProduct{

    @Override
    public void printInfo(){
        System.out.println("컴퓨터 상품입니다. 최대구매수량은 " + MAX_NUM + "개 입니다");
        // IProduct.MAX_NUM, MAX_NUM와 같이 사용 가능함




    }
    public void game(){
        System.out.println("컴퓨터 게임입니다....");
    }
}
