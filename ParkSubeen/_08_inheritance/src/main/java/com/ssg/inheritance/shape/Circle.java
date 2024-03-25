package com.ssg.inheritance.shape;

public class Circle extends Shape{
    Point point;
    private int radius;

    public Circle(Point point, int radius) {
        this.point = point;
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("중심점이 (" + point.getX() + ", " + point.getY() + ")이고, 반지름이 " + radius + "인 원을 그린다.");
    }

    @Override
    public double getArea() {
        return Math.round(radius * radius * Math.PI * 1000000) / 1000000.0;
    }
}
