package com.ssg.oop.product.model;

public class Product {
	private String productID;		//상품아이디
	private String productName;	//상품명
	private String productArea;	//생산지역
	private int price;				//가격
	private double tax;			//부가세비율
	
	//기본 생성자 생성
	public Product(){

	}
	
	//필드가 있는 생성자 추가
	public Product(String productID, String productName, String productArea, int price, double tax) {
		this.productID = productID;
		this.productName = productName;
		this.productArea = productArea;
		this.price = price;
		this.tax = tax;
	}
	
	//출력 메소드
	public void information(){
		String info = productID + "\t" + productName + "\t" + productArea + "\t" + price + "\t" + tax;
		System.out.println(info);
	}

	//getter & setter
	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductArea() {
		return productArea;
	}

	public void setProductArea(String productArea) {
		this.productArea = productArea;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

}

