package com.sh.polymorphism._03._interface;

public class Monitor implements IProduct {

    // 추상메소드 = 미완성메소드

    @Override
    public void printInfo() {
        System.out.println("모니터 상품입니다. 최대구매수량은" + MAX_NUM + "개 입니다.");
    }

    public void changeColorMode() {
        System.out.println("모니터의 컬러 모드를 변경합니다...");
    }


}
