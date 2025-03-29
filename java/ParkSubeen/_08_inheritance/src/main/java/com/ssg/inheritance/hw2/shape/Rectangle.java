package com.ssg.inheritance.hw2.shape;

public class Rectangle extends Shape{
    Point[] points;
    private int width;
    private int height;

    public Rectangle() {
    }

    public Rectangle(Point[] points) {
        this.points = points;
        this.width = points[1].getX() - points[0].getX();
        this.height = points[3].getY() - points[0].getY();
    }

    public Rectangle(Point leftTop, int width, int height) {
        points = new Point[4];
        points[0] = leftTop;
        points[1] = new Point(leftTop.getX() + width, leftTop.getY());
        points[2] = new Point(leftTop.getX() + width, leftTop.getY() + height);
        points[3] = new Point(leftTop.getX(), leftTop.getY() + height);
        this.width = width;
        this.height = height;
    }

    public Rectangle(Point leftTop, Point rightBottom) {
        this.width = rightBottom.getX() - leftTop.getX();
        this.height = rightBottom.getY() - leftTop.getY();
        points = new Point[4];
        points[0] = leftTop;
        points[1] = new Point(leftTop.getX() + width, leftTop.getY());
        points[2] = rightBottom;
        points[3] = new Point(leftTop.getX(), leftTop.getY() + height);
    }

    @Override
    public void draw() {
        System.out.println("네 꼭지점이 (" +
                            points[0].getX() + ", " + points[0].getY() + "), (" +
                            points[1].getX() + ", " + points[1].getY() + "), (" +
                            points[2].getX() + ", " + points[2].getY() + "), (" +
                            points[3].getX() + ", " + points[3].getY() + ")이고, 너비가 " + width + ", 높이가 " + height + "인 사각형을 그린다.");
    }

    @Override
    public double getArea() {
        return width * height;
    }
}
