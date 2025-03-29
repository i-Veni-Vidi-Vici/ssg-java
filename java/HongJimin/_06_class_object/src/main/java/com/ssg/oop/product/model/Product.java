package com.ssg.oop.product.model;

public class Product {
    private String product;
    private String productName;
    private String productArea;
    private int price;
    private double tex;

    public Product() {
    }

    public Product(String product, String productName, String productArea, int price, double tex) {
        this.product = product;
        this.productName = productName;
        this.productArea = productArea;
        this.price = price;
        this.tex = tex;
    }

    public void information() { //객체가 가진 5개 필드값 출력 메소드
        System.out.print(getProduct() + "\t");
        System.out.print(getProductName() +"\t");
        System.out.print(getProductArea() + "\t");
        System.out.print(getPrice() + "\t");
        System.out.print(getTex() + "\n");
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
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
