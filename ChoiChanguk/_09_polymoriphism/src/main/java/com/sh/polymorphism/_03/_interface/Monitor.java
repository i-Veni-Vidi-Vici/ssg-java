package com.sh.polymorphism._03._interface;

public class Monitor implements IProduct{
    @Override
    public void printInfo() {
        System.out.println("모니터 입니다 - 최대 구매 수량 : "+MAX_NUM);

    }
    public void changeColorMode()
    {
        System.out.println("모니터의 컬러 모드를 변경합니다");
    }
}
