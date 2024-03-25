package com.sh.inheritance._03_abstraction;

import java.time.LocalDate;

public class Product {
//    protected String code;
//    protected String brand;
//    protected String name;
//    protected int price;
//    protected LocalDate manuFacturingDate;
    private String code;
    private String brand;
    private String name;
    private int price;
    private LocalDate manuFacturingDate;
    public Product() {
        System.out.println("Product 기본 호출입니다");
    }

    public Product(String code, String brand, String name, int price, LocalDate manuFacturingDate) {
        System.out.println("필드 생성자 호출입니다");
        this.code = code;
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.manuFacturingDate = manuFacturingDate;
    }

    public String getInfo() {
        return "Product["+code+", "+brand+", "+name+", "
                +price+", "+manuFacturingDate+"]";
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
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

    public LocalDate getManuFacturingDate() {
        return manuFacturingDate;
    }

    public void setManuFacturingDate(LocalDate manuFacturingDate) {
        this.manuFacturingDate = manuFacturingDate;
    }
}
