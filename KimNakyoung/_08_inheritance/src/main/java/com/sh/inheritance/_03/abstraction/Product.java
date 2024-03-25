package com.sh.inheritance._03.abstraction;

import java.time.LocalDate;

public class Product {

    // 추상화  (== 일반화) ( 공통적인거 뽑아냈다)

    private String code;
    private String brand;
    private String name;
    private int price;
    private LocalDate manufacturingDate;

    // 기본생성자
    public Product() {
        System.out.println("Product 기본생성자 호출!!");
    }

    public Product(String code, String brand, String name, int price, LocalDate manufacturingDate) {
        this.code = code;
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.manufacturingDate = manufacturingDate;
    }

    // getter setter

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

    public String getInfo(){
        return "Product[" + code + ", " + brand + "," + name + ", " + price + " ," + manufacturingDate + "]";
    }
}
