package com.sgg.oop.product.controller;

public class Product {
    private String productId; // 상품아이디
    private String productName; // 상품명
    private String productArea; // 생산자
    private int price; // 가격
    private double tex; // 부가세비율

    // 기본생성자
    public Product() {
    }

    // 필드가 있는 생성자 추가 = 필드생성자
    public Product(String productId, String productName, String productArea, int price, double tex) {
        this.productId = productId;
        this.productName = productName;
        this.productArea = productArea;
        this.price = price;
        this.tex = tex;
    }

    // 5개의 필드값 출력하는 메소드
    public void information() {
        String info = productId + "\t" + productName + "\t" + productArea + "\t" + price + "\t" + tex ;
        System.out.println(info);

    }

    // getter/setter
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
