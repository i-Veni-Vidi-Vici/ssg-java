package com.sh.polymorphism_03._interface;

public class Monitor implements IProduct{
    @Override
    public void getInfo() {
        System.out.println("모니터 상품입니다. 최대 구매수량은 " + MAX_VALUE + "개 입니다." );

    }

    public void changeColorMonitor(){
        System.out.println("모니터의 컬러 모드를 변경합니다.");
    }
}
