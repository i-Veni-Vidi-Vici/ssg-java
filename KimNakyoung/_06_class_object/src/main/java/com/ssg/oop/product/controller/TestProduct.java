package com.ssg.oop.product.controller;

import com.ssg.oop.product.model.Product;

/**
 *
 * 실행 클래스
 *
 */
public class TestProduct {
    public static void main(String[] args) {

        //요구사항 1번

        //1. 매개변수 있는 생성자를 사용해서 3개의 객체를 생성함
        Product product = new Product("ssgnote6","갤럭시노트6","경기도수원",960000,10.0);
        product.information(); //2. 객체가 가진 필드값 출력확인
        Product product1 = new Product("lgxnote5","LG스마트폰5","경기도평택",780000,0.7);
        product1.information();
        Product product2 = new Product("ktnorm3","KT일반폰3","서울시강남",25000,0.3);
        product2.information();

//        Product product3 = new Product();
//        product3 = new Product();

        System.out.println();

        Product product3 = new Product("ssgnote6","갤럭시노트6","경기도수원",1200000,0.05);
        product3.information2(); //2. 객체가 가진 필드값 출력확인
        Product product4 = new Product("lgxnote5","LG스마트폰5","경기도평택",1200000,0.05);
        product4.information2();
        Product product5 = new Product("ktnorm3","KT일반폰3","서울시강남",1200000,0.05);
        product5.information2();
        
    }
}
