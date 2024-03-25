package com.ssg.oop.product.controller;

import com.ssg.oop.product.model.Product;

public class TestProduct {

    public static void main(String[] args) {

        /**
         * 요구사항 1번
         * - 3개의 객체 생성
         * - 필드값 출력 확인
         */
        Product product1 = new Product("ssgnote ","갤럭시노트6 ",
                                        "경기도수원 ",960000,10.0);

        Product product2 = new Product("lgxnote ","LG스마트폰6 ",
                                                "경기도 평택 ",780000,0.7);

        Product product3 = new Product("ktnorm3 ","KT일반폰3 ",
                                                "서울시 강남 ",250000,0.3);

        product1.inforamtion();
        product2.inforamtion();
        product3.inforamtion();
        System.out.println();

        /**
         * 요구사항 2번
         * - 각 객체의 가격을 120만원으로 변경
         * - 각 객체의 부가세율도 모두 0.05로 수정
         * - 부가세율을 적용한 실제 가격을 계산 (가격 = 가격 +(가격 * 부가세율)
         * totalPrice = price + (price * tex)
         */

       product1.setPrice(1200000);
       product1.setTex(0.05);
       int total =(int)(product1.getPrice() + (product1.getPrice() * product1.getTex()));
        System.out.println("상품명 : " + product1.getProductName());
        System.out.println("부가세 포함 가격 "+ total + "원 ");
       product2.setPrice(1200000);
       product2.setTex(0.05);
       int total2 =(int)(product2.getPrice() + (product2.getPrice() * product2.getTex()));
       System.out.println("상품명 : " + product2.getProductName());
       System.out.println("부가세 포함 가격 "+ total2 + "원 ");

       product3.setPrice(1200000);
       product3.setTex(0.05);
       int total3 =(int)(product3.getPrice() + (product3.getPrice() * product3.getTex()));
       System.out.println("상품명 : " + product3.getProductName());
       System.out.println("부가세 포함 가격 "+ total3 + "원 ");





    }
}
