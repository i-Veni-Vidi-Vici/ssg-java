package com.ssg.test.inheritance.shape;

public class Circle extends Shape {
    private Point center;   // has-a 포함관계
    private int r; // 반지름

    public Circle(Point center, int r) {
        this.center = center;
        this.r = r;
    }

    @Override
    public double getArea() {
        return Math.round(r * r * Math.PI * 1000) / 1000.0;
    }   // 소수점 셋째자리까지 반올림

    @Override
    public void draw(){
//        System.out.println("중심점이 (" + center.getX() + ", " + center.getY() + ")이고, 반지름이 " + r + "인 원을 그린다.");
        // toString() 명시적 호출을 했으므로 객체만 써도 좌표값이 문자열로 변환되어 출력된다
//        System.out.println("중심점이 " + center.toString() + "이고, 반지름이 " + r + "인 원을 그린다.");
        System.out.println("중심점이 " + center + "이고, 반지름이 " + r + "인 원을 그린다.");
    }
}
