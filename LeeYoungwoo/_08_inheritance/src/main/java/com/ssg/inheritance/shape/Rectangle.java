package com.ssg.inheritance.shape;

public class Rectangle extends Shape{
    private Point[] points;
    private int width;
    private int height;

    public Rectangle() {
    }
    public Rectangle(Point[] points) {
        super();
        this.points = points;
        this.width = points[1].getX() - points[0].getX();
        this.height = points[2].getY() - points[1].getY();
    }

    public Rectangle(Point leftTop, int width, int height) {
        Point[] points1 = new Point[4];
        points1[0] = leftTop;
        points1[1] = new Point(leftTop.getX() + width, leftTop.getY());
        points1[2] = new Point(leftTop.getX() + width, leftTop.getY() + height);
        points1[3] = new Point(leftTop.getX(), leftTop.getY() + height);
        this.width = width;
        this.height = height;
    }

    public Rectangle(Point leftTop, Point rightBottom) {
        this.width = rightBottom.getX() - leftTop.getX();
        this.height = rightBottom.getY() - leftTop.getY();
        points = new Point[4];
        points[0] = leftTop;
        points[1] = new Point(rightBottom.getX() - leftTop.getX(), rightBottom.getY() - leftTop.getY());
        points[2] = rightBottom;
        points[3] = new Point(leftTop.getX(), height);

    }

    @Override
    public void draw() {
        System.out.println("네 꼭지점이 (0, 0), (200, 0), (200, 100), (0, 100)이고, 너비가 200, 높이가 100인 사각형을 그린다.");
    }

    @Override
    public double getArea() {
        System.out.println(width);
        System.out.println(height);
        return width * height;
    }
}
