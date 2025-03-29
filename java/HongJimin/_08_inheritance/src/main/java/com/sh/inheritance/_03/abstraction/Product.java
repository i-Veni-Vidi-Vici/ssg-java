package com.sh.inheritance._03.abstraction;

import java.time.LocalDate;

public class Product {
    private String code;
    private String brand;
    private String name;
    private int price;
    private LocalDate manufacturingDate;

    public Product() {
        System.out.println("🎇Product 기본 생성자 호출!!");
    }

    public Product(String code, String brand, String name, int price, LocalDate manufacturingDate) {
        System.out.println("Product 필드 생성자 호출!!");
        this.code = code;
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.manufacturingDate = manufacturingDate;
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

    public LocalDate getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(LocalDate manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public String getInfo() {
        return "Product[" + code + ", " + brand + ", " + name + ", " + price + ", " + manufacturingDate + "]";
    }
}
