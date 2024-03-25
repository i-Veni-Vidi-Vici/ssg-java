package com.sh.polymorphism._02._abstract._class;

public class SmartPhone extends Product{
    private String carrier;
    public SmartPhone() {
    }

    public SmartPhone(String code, String name, int price, String carrier) {
        super(code, name, price);
        this.carrier = carrier;
    }

    @Override
    public void printInfo(){
        System.out.println("[" + getCode() + "]" + getName() + " - " + getPrice() + "원 " + this.carrier);
    }
}
