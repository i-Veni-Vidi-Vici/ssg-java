package com.ssg.hw2.shape;

import java.util.Arrays;

public class Rectangle extends Shape {

    private Point[] points = new Point[4];
    private int width;
    private int height;

    public Rectangle() {
    }

    public Rectangle(Point[] points) {
        super();
        this.points[0] = points[0];
        this.points[1] = points[1];
        this.points[2] = points[2];
        this.points[3] = points[3];
        width = points[1].getX() - points[0].getX();
        height = points[3].getY() - points[1].getY();
    }
    public Rectangle(Point leftTop, int width, int height) {
        this.points[0] = leftTop;
        this.points[1] = new Point(leftTop.getX()+width, leftTop.getY());
        this.points[2] = new Point(leftTop.getX()+width, leftTop.getY()+height);
        this.points[3] = new Point(leftTop.getX(), leftTop.getY()+height);
        this.width = width;
        this.height = height;
    }

    public Rectangle(Point leftTop, Point rightBottom) {
        this.points[0] = leftTop;
        this.points[1] = new Point(rightBottom.getX(), leftTop.getY());
        this.points[2] = rightBottom;
        this.points[3] = new Point(leftTop.getX(), rightBottom.getY());
        width = points[1].getX() - points[0].getX();
        height = points[3].getY() - points[0].getY();
    }

//    public void draw() {
//        System.out.printf("네 꼭지점이 (%d, %d), (%d, %d), (%d, %d), (%d, %d)이고, 너비가 %d 높이가 %d인 사각형을 그린다."
//        , points[0].getX(), points[0].getY(), points[1].getX(), points[1].getY(), points[2].getX(), points[2].getY(), points[3].getX(), points[3].getY(),
//                width, height
//                );
//    }

    public Rectangle(Point[] points, int width, int height) {
        this.points = points;
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("네 꼭지점이 [ " + points[0] + "," + points[1] + "," + points[2] + "," + points[3] + " ]이고, 너비가 "
                + width + ", 높이가 " + height + "인 사각형을 그린다.");
    }

    @Override
    public String toString() {
        return "Rectangle [points=" + Arrays.toString(points) + ", width=" + width + ", height=" + height + "]";
    }

    public double getArea() {
        return width * height;
    }
}
