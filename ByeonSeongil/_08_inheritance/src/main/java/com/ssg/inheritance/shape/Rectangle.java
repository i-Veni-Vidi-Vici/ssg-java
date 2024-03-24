package com.ssg.inheritance.shape;

public class Rectangle extends Shape {
    private Point[] points = new Point[4];
    private int width;
    private int height;

    public Rectangle() {
    }

    public Rectangle(Point[] points) {
        this.points = points;
        this.width = Math.abs(points[0].getX() - points[1].getX());
        this.height = Math.abs(points[0].getY() - points[3].getY());
    }

    public Rectangle(Point leftTop, int width, int height) {
        points[0] = leftTop;
        points[1] = new Point(points[0].getX() + width, points[0].getY());
        points[2] = new Point(points[1].getX(), points[1].getY() + height);
        points[3] = new Point(points[0].getX(), points[0].getY() + height);
        this.width = width;
        this.height = height;
    }

    public Rectangle(Point leftTop, Point rightBottom) {
        points[0] = leftTop;
        points[2] = rightBottom;
        this.width = Math.abs(points[0].getX() - points[2].getX());
        this.height = Math.abs(points[0].getY() - points[2].getY());
        points[1] = new Point(points[0].getX() + width, points[0].getY());
        points[3] = new Point(points[0].getX(), points[0].getY() + height);
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public void draw() {
        System.out.printf("네 꼭지점이 (%d, %d), (%d, %d), (%d, %d), (%d, %d)이고, 너비가 %d, 높이가 %d인 사각형을 그린다.",
                points[0].getX(), points[0].getY(),
                points[1].getX(), points[1].getY(),
                points[2].getX(), points[2].getY(),
                points[3].getX(), points[3].getY(),
                this.width, this.height
        );
    }
}
