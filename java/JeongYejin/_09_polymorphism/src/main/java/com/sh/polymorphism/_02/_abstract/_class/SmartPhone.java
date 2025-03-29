package com.sh.polymorphism._02._abstract._class;

public class SmartPhone extends Product{
    // Class 'SmartPhone' must either be declared abstract or implement abstract method 'printInfo()' in 'Product'

    private String carrier;
    public SmartPhone() {
    }

    public SmartPhone(String code, String name, int price, String carrier) {
        super(code, name, price);
        this.carrier = carrier;
    }

    /**
     * 추상메소드를 구현하지 않으면 컴파일 오류가 발생
     */
    @Override
    public void printInfo() { // 작성하니 위의 오류가 사라짐 => 구현 강제화
        System.out.println("[" + getCode() + "] " + getName() + "(" + carrier + ")" + " - " + getPrice() + "원");
    }

}
