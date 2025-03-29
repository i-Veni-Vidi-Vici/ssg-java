package com.ssg.oop.product.controller;

import com.ssg.oop.product.model.Product;

public class TestProduct {
    public static void main(String[] args) {
        Product product1 = new Product("ssgnote6", "갤럭시노트6", "경기도수원", 960000, 10.0);
        product1.information();
        Product product2 = new Product("lgxnote5", "LG스마트폰5", "경기도평택", 780000, 0.7);
        product2.information();
        Product product3 = new Product("ktnorm3", "KT일반폰3", "서울시강남", 25000, 0.3);
        product3.information();

        product1.setPrice(1_200_000);
        product2.setPrice(1_200_000);
        product3.setPrice(1_200_000);
        product1.setTex(0.05);
        product2.setTex(0.05);
        product3.setTex(0.05);

        System.out.println("상품명: " + product1.getProductName());
        System.out.println("부가세 포함 가격: " + (product1.getPrice() + (int)(product1.getPrice() * product1.getTex())) + " 원");
        System.out.println("상품명: " + product2.getProductName());
        System.out.println("부가세 포함 가격: " + (product2.getPrice() + (int)(product2.getPrice() * product2.getTex())) + " 원");
        System.out.println("상품명: " + product3.getProductName());
        System.out.println("부가세 포함 가격: " + (product3.getPrice() + (int)(product3.getPrice() * product3.getTex())) + " 원");
    }
}
