package com.sh.ineritance._03.abstraction;

import java.time.LocalDate;


//공통적인 부분들을 모아서 클래스로 만듦
public class Product {
    private String code;
    private String brand;
    private String name;
    private int price;
    private LocalDate manufacturingDate;

    public Product() {
        System.out.println("product 기본 새성자 호출 ");
    }

    public Product(String code, String brand, String name, int price, LocalDate manufacturingDate) {
        System.out.println("product 필드 생성자 호출");
        this.code = code;
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.manufacturingDate = manufacturingDate;
    }

    public String getInfo(){
        return "Product[" + code + "," + brand + "," + name + ","
                        + price + "," + manufacturingDate + "]";}

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


}
