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
//		System.out.println("원점이 ("+center.getX()+", "+center.getY()+")이고, 반지름이 "+r+"인 원을 그린다.");
        System.out.println("원점이 " + center.toString() + "이고, 반지름이 " + r + "인 원을 그린다.");
    }

    /**
     * 올림 Math.ceil(double):double
     * 내림 Math.floor(double):double
     * 반올림 Math.round(double):long
     *
     * 100.1234567
     * -> 100123456.7
     * -> 100123457 (long)
     * -> (x) 100123457 / 1000000 -> 100 소수점이하 유실
     * -> 100123457 / 1000000.0 -> 100.123457
     * -> 100.123457
     * @return
     */
    @Override
    public double getArea() {
        return Math.round(r * r * Math.PI * 1000000) / 1000000.0;
    }

}
