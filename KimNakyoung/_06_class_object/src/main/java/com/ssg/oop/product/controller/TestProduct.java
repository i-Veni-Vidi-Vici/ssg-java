package com.ssg.oop.product.controller;

import com.ssg.oop.product.model.Product;

/**
 *
 * 실행 클래스
 *
 */
public class TestProduct {
    public static void main(String[] args) {

        Product product = new Product("ssgnote6","갤럭시노트6","경기도수원",960000,10.0);
        product.information();
        Product product1 = new Product("lgxnote5","LG스마트폰5","경기도평택",780000,0.7);
        product1.information();
        Product product2 = new Product("ktnorm3","KT일반폰3","서울시강남",25000,0.3);
        product2.information();

//        Product product3 = new Product();
//        product3 = new Product();
        
    }
}
