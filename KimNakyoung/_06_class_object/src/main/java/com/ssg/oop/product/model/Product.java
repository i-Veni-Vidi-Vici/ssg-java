package com.ssg.oop.product.model;

public class Product {
    private String productId;
    private String productName;
    private String productArea;
    private int price;
    private double tex;

    // 객체가 가진 5개의 필드값 출력하는 메소드
    public void information(){
        System.out.println(productId + " " + productName + " " + productArea + " " + price + " " + tex );

    }
    // 기본생성자
    public Product(){

    }

    // 5개의 필드 초기화하는 매개변수 있는 생성자
    public Product(String productId,String productName,String productArea,int price,double tex){
        this.productId = productId;
        this.productName = productName;
        this.productArea = productArea;
        this.price = price;
        this.tex = tex;
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
