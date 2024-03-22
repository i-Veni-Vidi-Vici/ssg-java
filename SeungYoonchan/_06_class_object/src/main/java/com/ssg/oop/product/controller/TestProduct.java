package com.ssg.oop.product.controller;
import com.ssg.oop.product.model.Product;

public class TestProduct {
    public static void main(String[] args) {
        // 요구사항 1번
        // 매개변수 있는 생성자를 사용해서 3개의 객체를 생성
        Product product1 = new Product("ssgnote6", "갤럭시노트6", "경기도수원", 960000, 10.0);
        Product product2 = new Product("lgxnote5", "LG스마트폰5", "경기도평택", 780000, 0.7);
        Product product3 = new Product("ktnorm3", "KT일반폰3", "서울시강남", 25000, 0.3);

        // 객체가 가진 필드값 출력확인
        product1.information();
        product2.information();
        product3.information();
        System.out.println();
        // 요구사항 2번
        // 각 객체의 가격을 각각 120만원으로 변경
        // 각 객체의 부가세율도 모두 0.05로 수정
        product1.setPrice(1200000);
        product1.setTax(0.05);

        product2.setPrice(1200000);
        product2.setTax(0.05);

        product3.setPrice(1200000);
        product3.setTax(0.05);

        // 각 객체의 가격에 부가세율을 적용한 실제 가격을 계산하여 출력
        System.out.println("상품명 : " + product1.getProductName());
        System.out.println("부가세 포함 가격 : " + (int)(product1.getPrice() + (product1.getPrice() * product1.getTax())) + " 원\n");

        System.out.println("상품명 : " + product2.getProductName());
        System.out.println("부가세 포함 가격 : " + (int)(product2.getPrice() + (product2.getPrice() * product2.getTax())) + " 원\n");

        System.out.println("상품명 : " + product3.getProductName());
        System.out.println("부가세 포함 가격 : " + (int)(product3.getPrice() + (product2.getPrice() * product3.getTax())) + " 원\n");
    }
}
