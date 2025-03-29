package com.sh._03._interface;

import java.io.Serializable;

/**
 * Serializable 객체입출력시에 필요한 인터페이스
 */
public class Computer  implements IProduct, Serializable {

    @Override
    public void printInfo() {
        System.out.println("컴퓨터 상품입니다. 최대구먀수량은 " + IProduct.MAX_NUM + "개 입니다.");
        // IProduct

    }

    public void game() {
        System.out.println();
    }

}
