package com.ssg.stream.product;

public class Product {
    private String productName;
    private String brand;
    private String category;
    private int price;

    public Product() {
    }
    public Product(String productName, String brand, String category, int price) {
        this.productName = productName;
        this.brand = brand;
        this.category = category;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", brand='" + brand + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}
