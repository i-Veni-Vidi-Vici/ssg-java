package com.sh.polymorphism._03._interface;

import java.io.Serializable;

/**
 * Serializable 객체 입출력시에 필요한 인터페이스
 */

public class Computer implements Iproduct, Serializable {
    public void printInfo(){
        System.out.println("컴퓨터 상품입니다.최대구매수량은"+MAX_NUM+"개입니다.");
    }
    public void game(){
        System.out.println("게임을 시작합니다....");
    }
}
