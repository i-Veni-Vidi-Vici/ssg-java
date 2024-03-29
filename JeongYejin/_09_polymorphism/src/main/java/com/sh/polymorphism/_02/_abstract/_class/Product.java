package com.sh.polymorphism._02._abstract._class;

/**
 * <pre>
 * Product 추상클래스
 * - Product는 객체화할 수 없다. 할 필요가 없어서 하지못하게 막는다?
 * - 자식클래스가 구현해야할 내용을 추상 메소드로 강제화한다.
 * </pre>
 */
public abstract class Product { // 미완성이라고 명시하면 'Product' is abstract; cannot be instantiated 오류
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
     * - abstract 키워드
     * - 몸통을 작성하지 않는다
     */
    public abstract void printInfo(); // {} (X)
    // 클래스명 앞에 Abstract 명시를 지우면 오류! Abstract method in non-abstract class
}
