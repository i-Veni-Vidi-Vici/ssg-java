package com.ssg.hw2.shape;

public class Circle extends Shape {

    Point point;
    private int r;
    public Circle(Point point, int r) {
        this.point = point;
        this.r = r;
    }

    public void draw() {
        System.out.printf("중심점이 (%d, %d)이고, 반지름이 %d인 원을 그린다.", point.getX(), point.getY(), r);
    }
    public double getArea() {
        return r * r * Math.PI;
    }
}
