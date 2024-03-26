package com.sh.polymorphism._02._abstract._class;

/**
 * <pre>
 *
 * </pre>
 */

public abstract class Product {
    private String code;
    private String name;
    private int price;

    // 생성자
    public Product() {
    }

    public Product(String code, String name, int price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    // getter/setter
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
     * <pre>
     *     추상메소드
     *     - abstract 키워드
     *     - 몸통을 작성하지 않는다.
     * </pre>
     */
    public abstract void printInfo();
}
