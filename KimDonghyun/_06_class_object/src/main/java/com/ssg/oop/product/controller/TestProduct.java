package com.ssg.oop.product.controller;

import com.sh.oop.product.model.Product;

public class TestProduct {

	public static void main(String[] args) {
		//1단계: 객체생성 및 출력
		Product p1 = new Product("ssgnote6", "갤럭시노트6", "경기도 수원시", 960000, 10.0);
		Product p2 = new Product("lgxnote5", "LG스마트폰6", "경기도 평택시", 780000, 0.7);
		Product p3 = new Product("ktnorm3", "KT일반폰3 ", "서울시 강남", 250000, 0.3);
		
		p1.information();
		p2.information();
		p3.information();
		
		//2단계: setter추가후 가격을 120만원으로 변경, 부가세율 모두 0.5로 수정후 결과확인.
		p1.setPrice(1200000);
		p2.setPrice(1200000);
		p3.setPrice(1200000);
		
		p1.setTax(0.05);
		p2.setTax(0.05);
		p3.setTax(0.05);
		
		p1.information();
		p2.information();
		p3.information();
		
		//3단계: 실제가격출력
		String pName = p1.getProductName();
		int price = p1.getPrice()+(int)(p1.getPrice()*p1.getTax());
		System.out.println("상품명 : "+pName);
		System.out.println("부가세포함 판매가 : "+price);

		pName = p2.getProductName();
		price = p2.getPrice()+(int)(p2.getPrice()*p2.getTax());
		System.out.println("상품명 : "+pName);
		System.out.println("부가세포함 판매가 : "+price);
		

		pName = p3.getProductName();
		price = p3.getPrice()+(int)(p3.getPrice()*p3.getTax());
		System.out.println("상품명 : "+pName);
		System.out.println("부가세포함 판매가 : "+price);
		
		
		
	}

}
