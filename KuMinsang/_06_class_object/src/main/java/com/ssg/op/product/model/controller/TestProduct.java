package com.ssg.op.product.model.controller;

import com.ssg.op.product.model.Product;

public class TestProduct {
    public static void main(String[] args) {
        Product prod1 = new Product("ssgnote6", "갤럭시 노트6", "경기도 수원", 96000, 10.0);
        Product prod2 = new Product("lgxnote5", "V50", "경기도 팔당", 56000, 6.6);
        Product prod3 = new Product("ktgar", "포코폰", "전라도 여수", 38000, 5.0);

        prod1.information();
        prod2.information();
        prod3.information();

        prod1.setPrice(1_000_000);
        prod2.setPrice(1_000_000);
        prod3.setPrice(1_000_000);

        prod1.setTex(0.05);
        prod2.setTex(0.05);
        prod3.setTex(0.05);

        System.out.println("상품명 : "+prod1.getProductName()+ "부가세 포함 가격 : "+ (prod1.getPrice()+prod1.getPrice()*prod1.getTex()));
        System.out.println("상품명 : "+prod2.getProductName()+ "부가세 포함 가격 : "+ (prod2.getPrice()+prod2.getPrice()*prod2.getTex()));
        System.out.println("상품명 : "+prod3.getProductName()+ "부가세 포함 가격 : "+ (prod3.getPrice()+prod3.getPrice()*prod3.getTex()));

    }
}
