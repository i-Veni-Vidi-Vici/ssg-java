package com.ssg.op.product.model;

public class Product {
    private String productID;   //상품아이디
    private String productName; //상품명
    private String productArea;  //생산지
    private int price;  //가격
    private double tex; //부가세비율

    public Product(){}

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
        System.out.printf("%s %s %s %d %f\n", this.productID, this.productName, this.productArea, this.price, this.tex);
    }
}
