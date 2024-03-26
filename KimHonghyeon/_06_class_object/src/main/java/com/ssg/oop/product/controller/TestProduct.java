package com.ssg.oop.product.controller;

import com.ssg.oop.product.model.Product;

public class TestProduct {
    public static void main(String[] args) {
        Product product1 = new Product("1234", "커피", "에티오피아", 10000, 0.1);
        product1.information();
        Product product2 = new Product("3456", "노트북", "한국", 1500000, 0.3);
        product2.information();
        Product product3 = new Product("6789", "가방", "미국", 700000, 0.5);
        product2.information();

        product1.setPrice(1200000);
        product2.setPrice(1200000);
        product3.setPrice(1200000);

        product1.setTax(0.05);
        product2.setTax(0.05);
        product3.setTax(0.05);

        System.out.printf("제품명: %s\n", product1.getProductName());
        System.out.printf("부가세 포함 가격: %d\n", (int)(product1.getPrice()*(1+ product1.getTax())));
        System.out.printf("제품명: %s\n", product2.getProductName());
        System.out.printf("부가세 포함 가격: %d\n", (int)(product2.getPrice()*(1+ product2.getTax())));
        System.out.printf("제품명: %s\n", product2.getProductName());
        System.out.printf("부가세 포함 가격: %d\n", (int)(product3.getPrice()*(1+ product3.getTax())));
    }
}
