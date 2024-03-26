package com.sh.polymorphism._03._interface;

public class Monitor implements IProduct{
    @Override
    public void printInfo() {
        System.out.println("모니터 상품입니다. 최대수량: "+ IProduct.MAX_NUM);

    }
}
