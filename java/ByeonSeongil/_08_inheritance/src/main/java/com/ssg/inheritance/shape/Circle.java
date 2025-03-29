package com.ssg.inheritance.shape;

public class Circle extends Shape{

    private  Point point;
    private int radius;

    public Circle(Point point, int radius) {
        this.point =point;
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return radius * radius * Math.PI;
    }

    @Override
    public void draw() {
        System.out.printf("중심점이(%d, %d)이고, 반지름이 %d인 원을 그린다.", point.getX(), point.getY(), this.radius);
    }
}
