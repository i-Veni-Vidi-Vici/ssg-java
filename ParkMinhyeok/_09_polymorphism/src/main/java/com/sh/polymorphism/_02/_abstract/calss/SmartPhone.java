package com.sh.polymorphism._02._abstract.calss;

public class SmartPhone extends Product{
    public SmartPhone() {
    }

    public SmartPhone(String code, String name, int price) {
        super(code, name, price);
    }


    /**
     * 추상메소드를 구현하지 않으면 컴파일 오류 발생
     */
    @Override
    public void printInfo() {
        System.out.println("[" + getCode() + "]" + getName() + " - " + getPrice() + "원");
    }
}
