package com.sh.polymorphism._02._abstracct._class;

public class Keyboard extends Product{
    private String type;

    public Keyboard() {
    }

    public Keyboard(String code, String name, int price,String type) {
        super(code, name, price);
        this.type = type; // 확장
    }

    @Override
    public void printInfo() {
        System.out.println(" [" + getCode() + "]" + getName() + "-" + getPrice() + "원" + type);

    }
}
