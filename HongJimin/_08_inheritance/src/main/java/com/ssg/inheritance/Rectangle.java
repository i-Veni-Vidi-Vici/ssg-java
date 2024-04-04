package com.ssg.inheritance;

public class Rectangle extends Shape{
    private Point point;
    private int width;
    private int height;
    private Point [] newPoints = new Point[4];

    public Rectangle() {
    }

    public Rectangle(Point point, int width, int height) {
        this.point = point;
        this.width = width;
        this.height = height;
    }

    public Rectangle(Point[] points){
        this.width = points[1].getX() - points[0].getX();
        this.height = points[2].getY() - points[0].getY();
    }

    public Rectangle(Point point1, Point point2) {
        this.width = Math.abs(point1.getX()-point2.getX());
        this.height = Math.abs(point1.getY() - point2.getY());
    }

    @Override
    public double getArea() {
        return this.width * this.height;
    }

    @Override
    public void draw() {
        System.out.printf("네 꼭지점이 (%d, %d), (%d, %d), (%d, %d), (%d, %d)이고, 너비가 %d, 높이가 %d인 사각형을 그린다."
                , newPoints[0].getX(), newPoints[0].getY()
                , newPoints[1].getX(), newPoints[1].getY()
                , newPoints[2].getX(), newPoints[2].getY()
                , newPoints[3].getX(), newPoints[3].getY()
                ,this.width, this.height );
    }
}
