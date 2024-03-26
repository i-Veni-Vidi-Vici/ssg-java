package com.ssg.oop.product.model;

public class Product {
    private String productId, productName, productArea;
    private int price;
    private double tax;

    public Product() {
    }

    public Product(String productId, String productName, String productArea, int price, double tax) {
        this.productId = productId;
        this.productName = productName;
        this.productArea = productArea;
        this.price = price;
        this.tax = tax;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductArea() {
        return productArea;
    }

    public void setProductArea(String productArea) {
        this.productArea = productArea;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }
    public void information(){
        System.out.println("Id: "+ this.productId + " Name: " + this.productName + " Area: " + this.productArea + " Price: "+
                this.price + " Tax: "+ this.tax);
    }
}
