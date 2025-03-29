package com.sgg.oop.product.model;

import com.sgg.oop.product.controller.Product;

public class TestProduct {
    public static void main(String[] args) {

        // 요구사항 1번
        Product product1 = new Product("ssgnote6", "갤럭시노트6", "경기도수원", 960000, 10.0);
        Product product2 = new Product("lgxnote5", "LG스마트폰5", "경기도평택", 780000, 0.7);
        Product product3 = new Product("ktnorm3", "KT일반폰3", "서울시강남", 25000, 0.3);

        product1.information();
        product2.information();
        product3.information();

        // 요구사항 2번
        // 1. 각 개체의 가격을 각각 120만원으로 변경함 -> set사용(set은 값을 설정하는 역할)
        product1.setPrice(1200000);
        product2.setPrice(1200000);
        product3.setPrice(1200000);

        // 2. 각 객체의 부가세율도 모두 0.05로 수정함
        product1.setTex(0.05);
        product2.setTex(0.05);
        product3.setTex(0.05);

        // 확인해보기
        product1.information();
        product2.information();
        product3.information();

        // 각 객체의 가격에 부가세율을 적용한 실제가격을 계산
        // 실제 가격 = 가격 + (가격 * 부가세율)
        String name = product1.getProductName();
        int price = product1.getPrice() + (int)((product1.getPrice()) * (product1.getTex()));
        System.out.println("상품명 : " + name);
        System.out.println("부가세포함 판매가 : " + price);

        name = product2.getProductName();
        price = product2.getPrice() + (int)((product2.getPrice()) * (product2.getTex()));
        System.out.println("상품명 : " + name);
        System.out.println("부가세포함 판매가 : " + price);

        name = product3.getProductName();
        price = product3.getPrice() + (int)((product3.getPrice()) * (product3.getTex()));
        System.out.println("상품명 : " + name);
        System.out.println("부가세포함 판매가 : " + price);
    }

}
