package com.ssg.inheritance.shape;

public class Circle extends Shape{
    private Point point;
    private int halfDiemeter;

    public Circle() {
    }

    public Circle(Point point, int halfDiemeter) {
        this.point = point;
        this.halfDiemeter = halfDiemeter;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public int getHalfDiemeter() {
        return halfDiemeter;
    }

    public void setHalfDiemeter(int halfDiemeter) {
        this.halfDiemeter = halfDiemeter;
    }

    @Override
    public double getArea(){
        return halfDiemeter*Math.PI;
    }

    @Override
    public void draw() {
        System.out.printf("중심점이 (%d, %d)이고, 반지름이 %d인 원을 그린다.", point.getX(), point.getY(), halfDiemeter);
    }
}
