package com.ssg.oop.product.model;

public class Product {
    private String productId;   // 상품 아이디
    private String productName; // 상품명
    private String productArea; // 생산지
    private int price;  // 가격
    private double tex; // 부가세비율

    public Product() {}

    public Product(String productId, String productName, String productArea, int price, double tex) {
        this.productId = productId;
        this.productName = productName;
        this.productArea = productArea;
        this.price = price;
        this.tex = tex;
    }

    public void information() {
        System.out.println(this.productId + " " + this.productName + " " + this.productArea + " " + this.price + " " + this.tex);
    }

    public void modifyPrice(String productName, int price, double tex) {
        price = 1_200_000;
        tex = 0.05;
        int actualPrice = price + (int)(price * tex);

        System.out.println("상품명 : " + productName);
        System.out.println("부가세 포함 가격 : " + actualPrice + "원");
    }

    public void setProductId(String productId) {this.productId = productId;}
    public String getProductId() {return this.productId;}
    public void setProductName(String productName) {this.productName = productName;}
    public String getProductName() {return this.productName;}
    public void setProductArea(String productArea) {this.productArea = productArea;}
    public String getProductArea() {return this.productArea;}
    public void setPrice(int price) {this.price = price;}
    public int getPrice() {return this.price;}
    public void setTex(double tex) {this.tex = tex;}

    public double getTex() {return this.tex;}
}
