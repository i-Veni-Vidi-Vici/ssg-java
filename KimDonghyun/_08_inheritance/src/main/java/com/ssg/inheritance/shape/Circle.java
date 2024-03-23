package com.ssg.inheritance.shape;

public class Circle extends Shape {
	private Point center; //has a 포함관계
	private int r;

	public Circle(Point center, int r) {
		this.center = center;
		this.r = r;
	}
	
	@Override
	public void draw() {
		System.out.println("원점이 ("+center.getX()+", "+center.getY()+")이고, 반지름이 "+r+"인 원을 그린다.");
	}

	@Override
	public double getArea() {
		return Math.round(r * r * Math.PI * 1000000) / 1000000.0;
	}
	
}
