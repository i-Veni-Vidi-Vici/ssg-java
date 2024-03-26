package com.sh.polymorphism._02._abstract._class;

public class SmartPhone extends Product {
    private String carrier;
    public SmartPhone() {
    }

    public SmartPhone(String code, String name, int price, String carrier) {
        super(code, name, price);
        this.carrier = carrier;
    }

    /**
     * 추상클래스를 상속했을때,추상 메소드를 구현하지 않으면 컴파일 오류 발생
     */
    @Override
    public void printInfo(){
        System.out.println("[" + getCode() + "]" + getName() + "(" + carrier + ") -" + getPrice() + "원");
    }
}
