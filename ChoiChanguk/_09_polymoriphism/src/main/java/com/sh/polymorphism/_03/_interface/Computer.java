package com.sh.polymorphism._03._interface;

import java.io.Serializable;

/**
 * serializable 겍체입출력시에 필요한 인터페이스
 * */

public class Computer implements IProduct, Serializable {
    @Override
    public void printInfo() {
        System.out.println("컴퓨터 입니다 - 최대 구매수량은 : "+MAX_NUM);
        //부모 interface라서 상수 사용이 가능하다
    }

    public void game() {
        System.out.println("게임을 시작합니다");
    }
}
