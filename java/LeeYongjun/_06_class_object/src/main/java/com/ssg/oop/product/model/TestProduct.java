package com.ssg.oop.product.model;

public class TestProduct {
    public static void main(String[] args) {
        Product product = new Product();

        product.ProductInfo("ssgnote6", "갤럭시노트6", "경기도수원", 960000, 10.0);
        product.information();
        product.ProductInfo("lgxnote5", "LG스마트폰5", "경기도평택", 780000, 0.7);
        product.information();
        product.ProductInfo("ktnorm3", "KT일반폰3", "서울시강남", 25000, 0.3);
        product.information();

        product.ProductInfo("ssgnote6", "갤럭시노트6", "경기도수원", 960000, 10.0);
        product.ProductChg1();
        product.ProductInfo("lgxnote5", "LG스마트폰5", "경기도평택", 780000, 0.7);
        product.ProductChg2();
        product.ProductInfo("ktnorm3", "KT일반폰3", "서울시강남", 25000, 0.3);
        product.ProductChg3();

    }


}
