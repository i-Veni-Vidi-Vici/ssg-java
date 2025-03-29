package com.sh.inheritance._03.abstraction;

import java.time.LocalDate;

public class Product {

//    protected String code;
//    protected String branc;
//    protected String name;
//    protected int price;
//    protected LocalDate manufacturingDate;
    private String code;
    private String branc;
    private String name;
    private int price;
    private LocalDate manufacturingDate;

    public Product() {
        System.out.println("Product 기본생성자 호출!!!");
    }

    public Product(String code, String branc, String name, int price, LocalDate manufacturingDate) {
        System.out.println("Product 필드생성자 호출!!!!");
        this.code = code;
        this.branc = branc;
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

    public String getBranc() {
        return branc;
    }

    public void setBranc(String branc) {
        this.branc = branc;
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
        return "Product[" + code + ", " + branc + ", " + name
                + ", " + price + ", " + manufacturingDate + "]";
    }
}
