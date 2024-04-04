package com.ssg.inheritance;

public class Circle extends Shape{

    private Point point;
    private int radius;

    public Circle() {
    }

    public Circle(Point point, int radius) {
        this.point = point;
        this.radius = radius;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return radius * radius * Math.PI ;
    }
    @Override
    public void draw(){
        System.out.println("중심점이 (" + this.point.getX() + ", " + this.point.getY() +")" + "이고, " + "반지름이 " + getRadius()+"인 원을 그린다.");
    }
}
