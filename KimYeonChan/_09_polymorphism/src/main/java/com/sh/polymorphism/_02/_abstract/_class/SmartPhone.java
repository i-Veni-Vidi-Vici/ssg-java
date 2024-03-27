package com.sh.polymorphism._02._abstract._class;

public class SmartPhone extends Product{
    private String carrier;
    public SmartPhone() {}
    public SmartPhone(String code, String name, int price, String carrier) {
        super(code, name, price);
        this.carrier = carrier;
    }

    /**
     * 추상메소드를 구현하지 않으면 컴파일오류 발생
     */
    @Override
    public void printInfo() {
        System.out.println("[" + getCode() + "]" + getName() + "-" + getPrice() + "원");
        System.out.println("통신사: " + carrier);
    }
}
