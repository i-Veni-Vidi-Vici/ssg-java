package com.ssg.oop.product.model;

import javax.swing.*;

public class Product {

    private String productId;
    private String productName;
    private String productArea;
    private int price;
    private double tex;


    public Product(String productId, String productName, String productArea, int price, double tex) {
        this.productId = productId;
        this.productName = productName;
        this.productArea = productArea;
        this.price = price;
        this.tex = tex;
    }

    public Product(){

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

    public double getTex() {
        return tex;
    }

    public void setTex(double tex) {
        this.tex = tex;
    }

    public void inforamtion(){
        System.out.print(this.productId);
        System.out.print(this.productName);
        System.out.print(this.productArea);
        System.out.print(this.price);
        System.out.print(" ");
        System.out.print(this.tex);
        System.out.println();
    }

    int total = 0;
    public int totalPrice(int price, double tex){
        total =(int) (price + (price * tex));
        return total;
    }

}
