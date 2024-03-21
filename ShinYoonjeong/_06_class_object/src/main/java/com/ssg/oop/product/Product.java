package com.ssg.oop.product;

public class Product {
    private String productID;
    private String productName;
    private String productArea;
    private int price;
    private double tex;

    public Product(String productID, String productName, String productArea, int price, double tex) {
        this.productID = productID;
        this.productName = productName;
        this.productArea = productArea;
        this.price = price;
        this.tex = tex;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
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
    public void information(){
        System.out.println(productID + productName + productArea + price + tex);
    }
    public void information2(){
        System.out.println("상품명 : " + productName);
        System.out.println("부가세 포함 가격 : " + Math.ceil(price+(price*tex)) + "원");
    }
}
