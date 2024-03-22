package com.ssg.oop.product.model;

public class Product {
    private String productId;
    private String productName;
    private String productArea;
    private int price;
    private double tax;

    public Product(){}

    public Product(String productId, String productName, String productArea, int price, double tax) {
        this.productId = productId;
        this.productName = productName;
        this.productArea = productArea;
        this.price = price;
        this.tax = tax;
    }

    public int realPrice() {
        double price = this.price + (this.price * this.tax);
        return (int)price;
    }

    public void information() {
        System.out.print("""
                %s %s %s %d %.1f
                """.formatted(productId, productName, productArea, price, tax));
    }

    public void realInformation(int price) {
        System.out.print("""
                상품명 : %s
                부가세 포함 가격 : %d
                """.formatted(productName, price));
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
