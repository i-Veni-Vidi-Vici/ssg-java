package com.sh.polymorphism._02.abstrat._class;

/**
 * Product 추상클래스
 * -Product는 객체화 할 수 없다.
 * -자식클래스가 구현해야 할 내용을 추상메소드로 강제화 한다.
 */
public abstract class Product {
    private String code;
    private String name;
    private int price;


    public Product() {
    }

    public Product(String code, String name, int price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * 추상메소드
     * -abstract 키워드
     * -몸통{}을 작성하지 않는다.
     */
    public abstract void printInfo(); // 메소드 추가함 마찬가지로 추상임
}
