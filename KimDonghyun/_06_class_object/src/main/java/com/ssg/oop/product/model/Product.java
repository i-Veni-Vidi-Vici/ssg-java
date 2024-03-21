package com.ssg.oop.product.model;

public class Product {
	private String productID;		//상품아이디
	private String productName;	//상품명
	private String productArea;	//생산지
	private int price;				//가격
	private double tax;			//부가세비율
	
	//기본생성자생성
	public Product(){
		
	}
	
	//필드가 있는 생성자추가
	public Product(String productID, String productName, String productArea, int price, double tax) {
		this.productID = productID;
		this.productName = productName;
		this.productArea = productArea;
		this.price = price;
		this.tax = tax;
	}
	
	//출력메소드
	public void information(){
		String info = productID+"\t"+productName+"\t"+productArea+"\t"+price+"\t"+tax;
		System.out.println(info);
	}

	//2단계 : setter추가
	public void setProductID(String productID) {
		this.productID = productID;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setProductArea(String productArea) {
		this.productArea = productArea;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	//3단계 : getter추가
	public String getProductID() {
		return productID;
	}

	public String getProductName() {
		return productName;
	}

	public String getProductArea() {
		return productArea;
	}

	public int getPrice() {
		return price;
	}

	public double getTax() {
		return tax;
	}
	
	
	
	
}
