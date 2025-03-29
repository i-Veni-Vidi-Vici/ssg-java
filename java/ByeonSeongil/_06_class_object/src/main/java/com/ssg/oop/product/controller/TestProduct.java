package com.ssg.oop.product.controller;

import com.ssg.oop.product.model.Product;

public class TestProduct {
    public static void main(String[] args) {
        Product product1 = new Product("ssgnote6", "갤럭시노트6", "경기도수원", 960000, 10.0);
        Product product2 = new Product("lgxnote5", "LG스마트폰5", "경기도평택", 780000, 0.7);
        Product product3 = new Product("ktnorm3", "KT일반폰3", "서울시강남", 25000, 0.3);

        product1.information();
        product2.information();
        product3.information();

        product1.setPrice(1200000);
        product2.setPrice(1200000);
        product3.setPrice(1200000);

        product1.setTex(0.05);
        product2.setTex(0.05);
        product3.setTex(0.05);

        System.out.print("상품명 :" + product1.getProductName() + "\n");
        System.out.print("부가세 포함 가격 :" + (int)(product1.getPrice() + (product1.getPrice() * product1.getTex())) + "\n");

        System.out.print("상품명 :" + product2.getProductName() + "\n");
        System.out.print("부가세 포함 가격 :" + (int)(product2.getPrice() + (product2.getPrice() * product2.getTex())) + "\n");

        System.out.print("상품명 :" + product3.getProductName() + "\n");
        System.out.print("부가세 포함 가격 :" + (int)(product3.getPrice() + (product3.getPrice() * product3.getTex())) + "\n");


    }
}
