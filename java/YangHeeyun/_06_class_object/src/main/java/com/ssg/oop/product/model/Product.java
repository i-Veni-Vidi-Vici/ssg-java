package com.ssg.oop.product.model;

public class Product {

    private String productId; // 상품아이디
    private String productName; //상품명
    private String productArea; //생산지
    private int price; // 가격
    private double tax; // 부가세비율

    public Product() {
    }

    public Product(String productId, String productName, String productArea, int price, double tax){
        this.productId = productId;
        this.productName = productName;
        this.productArea = productArea;
        this.price = price;
        this.tax = tax;

    }

    public void information() {
        System.out.print("""
                %s %s %s %d %.1f
                """.formatted(productId, productName, productArea, price, tax));
    }

    public void taxInformation(){
        System.out.print("""
                상품명 : %s
                부가세 포함 가격 : %d 원
                """.formatted(productName,(int)(price + (price*tax))));
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
}

