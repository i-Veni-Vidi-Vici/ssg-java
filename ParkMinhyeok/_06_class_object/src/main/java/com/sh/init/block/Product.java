package com.sh.init.block;

public class Product {
    private String name = "아메리카노";
    private static String brand = "동서식품";
    // 인스턴스 변수 초기화 블럭
    {
        name = "카페라떼";
    }
    // 클래스변수 초기화 블럭
    static {
        brand = "스타벅스";
    }
    public Product (String name) {
        // 생성자를 통한 초기화 (우선순위가 가장 높다)
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public static String getBrand() {
        return brand;
    }
}
