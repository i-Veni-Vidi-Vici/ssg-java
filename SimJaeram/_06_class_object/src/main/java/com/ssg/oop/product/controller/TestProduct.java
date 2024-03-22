package com.ssg.oop.product.controller;

import com.ssg.oop.product.model.Product;

public class TestProduct {
    public static void main(String[] args) {
        // 요구사항 1번
        // 매개변수 있는 생성자를 사용해서 3개의 객체를 생성함
        Product ssgnote6 = new Product("ssgnote6", "갤럭시노트6", "경기도수원", 960000, 10.0);
        Product lgxnote5 = new Product("lgxnote5", "LG스마트폰5", "경기도평택", 780000, 0.7);
        Product ktnorm3 = new Product("ktnorm3", "KT일반폰3", "서울시강남", 25000, 0.3);

        // 객체가 가진 필드값 출력확인
        ssgnote6.information();
        lgxnote5.information();
        ktnorm3.information();
        System.out.println();

        // 요구사항 2번
        // 1. 각 객체의 가격을 각각 120만원으로 변경함
        ssgnote6.setPrice(1_200_000);
        lgxnote5.setPrice(1_200_000);
        ktnorm3.setPrice(1_200_000);
        // 2. 각 객체의 부가세율도 모두 0.05로 수정함
        ssgnote6.setTex(0.05);
        lgxnote5.setTex(0.05);
        ktnorm3.setTex(0.05);
        // 3. 각 객체의 가격에 부가세율을 적용한 실제 가격을 계산 실제 가격 = 가격 + (가격 * 부가세율)
        System.out.println("""
                상품명 : %s
                부가세 포함 가격 : %.0f원""".formatted(ssgnote6.getProductName(), ssgnote6.getPrice() + (ssgnote6.getPrice() * ssgnote6.getTex())));
        System.out.println("""
                상품명 : %s
                부가세 포함 가격 : %.0f원""".formatted(lgxnote5.getProductName(), lgxnote5.getPrice() + (lgxnote5.getPrice() * lgxnote5.getTex())));
        System.out.println("""
                상품명 : %s
                부가세 포함 가격 : %.0f원""".formatted(ktnorm3.getProductName(), ktnorm3.getPrice() + (ktnorm3.getPrice() * ktnorm3.getTex())));
    }
}
