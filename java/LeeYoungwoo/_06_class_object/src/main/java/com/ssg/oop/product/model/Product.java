package com.ssg.oop.product.model;

public class Product {
    private String productId;
    private String productName;
    private String productArea;
    private int price;
    private double tex;

    // Constructor 생성
    public Product() {}

    public Product(String productId, String productName, String productArea, int price, double tex) {
        this.productId = productId;
        this.productName = productName;
        this.productArea = productArea;
        this.price = price;
        this.tex = tex;
    }

    // Method 생성
    public void information() {
        System.out.print(getProductId() + " ");
        System.out.print(getProductName() + " ");
        System.out.print(getProductArea() + " ");
        System.out.print(getPrice() + " ");
        System.out.print(getTex() + "\n");
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

    public double getTex() {
        return tex;
    }

    public void setTex(double tex) {
        this.tex = tex;
    }
}
