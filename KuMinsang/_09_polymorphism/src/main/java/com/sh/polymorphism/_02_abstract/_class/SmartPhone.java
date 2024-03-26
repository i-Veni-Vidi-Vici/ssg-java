package com.sh.polymorphism._02_abstract._class;

public class SmartPhone extends Product{
    String carrier;
    public SmartPhone(){

    }

    public SmartPhone(String code, String name, int price, String carrier) {
        super(code, name, price);
        this.carrier = carrier;
    }

    /**
     * 추상메소드를 구현하지 않으면 컴파일 오류가 발생
     *
     */
    @Override
    public void printInfo() {
        System.out.println("[" + getCode() + "]" + getName() + " - "+this.carrier +" " + getPrice() + "원");
    }
}
