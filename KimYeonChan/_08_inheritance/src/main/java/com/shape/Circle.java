package com.shape;

public class Circle extends Shape{
    private Point point;
    private int radius;

    public Circle(Point point, int radius) {
        this.point = point;
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius *radius;
    }

    @Override
    public void draw() {
        System.out.printf("중심점이 (%d %d)이고, 반지금이 %d인 원을 그린다.\n", point.getX(), point.getY(), radius);
    }
}
