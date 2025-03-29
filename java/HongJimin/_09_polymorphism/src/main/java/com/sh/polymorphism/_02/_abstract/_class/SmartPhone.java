package com.sh.polymorphism._02._abstract._class;

public class SmartPhone extends Product{
    private  String carrier;
    public SmartPhone() { //기본생성자
    }

    public SmartPhone(String code, String name, int price, String carrier) { //parameter 생성자
        super(code, name, price);
        this.carrier = carrier;
    }

    /**
     * 추상메소드를 구현하지 않으면 컴파일 오류가 발생함
     */
    @Override
    public void printInfo() {
        System.out.println("[" + getCode() + "] " + getName() + "(" + carrier + ") - " + getPrice() + "원");
    }
}
