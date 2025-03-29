package com.ssg.oop.product;

public class Product {
    private String productId;
    private String productName;
    private String productArea;
    private int price;
    private double tax;

    Product(){}
    Product(String productId, String productName, String productArea, int price, double tax){
        this.productId = productId;
        this.productName = productName;
        this.productArea = productArea;
        this.price = price;
        this.tax = tax;
    }

    // 요구사항 1번
//    public void information(){
//        System.out.println(this.productId + " " + this.productName + " " + this.productArea + " " + this.price + " " + this.tax);
//    }

    // 요구사항 2번
    public void information(){
        String result = """
                상품명 : %s
                부가세 포함 가격 : %.0f 원
                """.formatted(this.productName, this.price + (this.price * this.tax));
        System.out.println(result);
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
