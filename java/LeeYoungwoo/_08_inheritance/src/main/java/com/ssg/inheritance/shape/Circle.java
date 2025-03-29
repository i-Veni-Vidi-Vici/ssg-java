package com.ssg.inheritance.shape;

import static java.lang.Math.PI;

public class Circle extends Shape {
    private Point point;
    private long radius;

    public Circle() {
    }

    public Circle(Point point, long radius) {
        this.point = point;
        this.radius = radius;
    }

    @Override
    public double getArea() {
        double d = PI * radius * radius;
        String str = String.format("%.6f", d);
        double result = Double.parseDouble(str);
        return result;
    }

    @Override
    public void draw() {
        System.out.println("중심점이 (100, 100)이고, 반지름이 10인 원을 그린다.");
    }
}
