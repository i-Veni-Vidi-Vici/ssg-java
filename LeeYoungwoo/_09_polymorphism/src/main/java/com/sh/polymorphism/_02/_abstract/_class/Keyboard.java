package com.sh.polymorphism._02._abstract._class;

public class Keyboard extends Product{
    private String type;
    public Keyboard() {
    }

    public Keyboard(String code, String name, int price, String type) {
        super(code, name, price);
        this.type = type;
    }

    public void printInfo(){
        System.out.println("[" + getCode() + "]" + getName() + " - "  + getPrice() + "원" +
                " 키보드(" + type + ")");
    }
}
