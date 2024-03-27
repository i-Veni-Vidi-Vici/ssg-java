package com.ssg.inheritance.shape;

public class Circle extends Shape{

    private Point point; // 중심점
    private int radius; // 반지름

    public Circle() {}

    public Circle(Point point, int radius) {
        this.point = point;
        this.radius = radius;
    }

    @Override
    public void draw(){
        System.out.printf("중심점이 (%d, %d)이고, 반지름이 %d인 원을 그린다.\n",point.getX(),point.getY() ,radius);
    }

    @Override
    public double getArea(){
        return Math.round(radius * radius * Math.PI * 1000000) / 1000000.0;
    }
}
