package com.ssg.oop.product.controller;

import com.ssg.oop.product.model.Product;

public class TestProduct {
    public static void main(String[] args) {
        Product product1 = new Product();
        product1.setProductId("ssgnote6");
        product1.setProductName("갤럭시노트6");
        product1.setProductArea("경기도수원");
        product1.setPrice(960000);
        product1.setTex(10.0);

        Product product2 = new Product();
        product2.setProductId("lgxnote5");
        product2.setProductName("LG스마트폰5");
        product2.setProductArea("경기도평택");
        product2.setPrice(780000);
        product2.setTex(0.7);

        Product product3 = new Product();
        product3.setProductId("ktnorm3");
        product3.setProductName("KT일반폰3");
        product3.setProductArea("서울시강남");
        product3.setPrice(25000);
        product3.setTex(0.3);

        // 요구사항 1번
        product1.information();
        product2.information();
        product3.information();
        System.out.println();

        // 요구사항 2번
        product1.modifyPrice(product1.getProductName(), product1.getPrice(), product1.getTex());
        product2.modifyPrice(product2.getProductName(), product2.getPrice(), product2.getTex());
        product3.modifyPrice(product3.getProductName(), product3.getPrice(), product3.getTex());
    }
}
