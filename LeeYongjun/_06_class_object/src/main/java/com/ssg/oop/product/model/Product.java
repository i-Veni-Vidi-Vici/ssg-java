package com.ssg.oop.product.model;

public class Product {
    private String productId;
    private String productName;
    private String productArea;
    private int price;
    private double tex;

    public void ProductInfo(){}
    public void ProductInfo(String productId, String productName, String productArea, int price, double tex) {
        this.productId = productId;
        this.productName = productName;
        this.productArea = productArea;
        this.price = price;
        this.tex = tex;
    }
    public void information(){
        System.out.println(productId + " " + productName + " " + productArea + " " + price + " " + tex);

    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductArea(String productArea) {
        this.productArea = productArea;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setTex(double tex) {
        this.tex = tex;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductArea() {
        return productArea;
    }

    public int getPrice() {
        return price;
    }

    public double getTex() {
        return tex;
    }

    public void ProductChg1() {
        setPrice(1200000);
        setTex(0.05);
        System.out.println("상품명 : " + productId +"\n" + "부가세 포함 가격 : " + (price + (price * tex)));
    }
    public void ProductChg2() {
        setPrice(1200000);
        setTex(0.05);
        System.out.println("상품명 : " + productId +"\n" + "부가세 포함 가격 : " + (price + (price * tex)));
    }
    public void ProductChg3() {
        setPrice(1200000);
        setTex(0.05);
        System.out.println("상품명 : " + productId +"\n" + "부가세 포함 가격 : " + (price + (price * tex)));
    }
}
