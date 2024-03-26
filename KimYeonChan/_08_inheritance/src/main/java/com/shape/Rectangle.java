package com.shape;

public class Rectangle extends Shape{
    private Point[] points = new Point[4];
    private int width;
    private int height;

    public Rectangle() {}
    public Rectangle(Point[] points) {
        this.points = points;
        this.width = points[1].getX() - points[0].getX();
        this.height = points[2].getY() - points[0].getY();
    }
    public Rectangle(Point leftTop, int width, int height) {
        this.points[0] = leftTop;
        this.points[1] = new Point(leftTop.getX() + width, leftTop.getY());
        this.points[2] = new Point(leftTop.getX() + width, leftTop.getY() + height);
        this.points[3] = new Point(leftTop.getX(), leftTop.getY() + height);
        this.width = width;
        this.height = height;
    }
    public Rectangle(Point leftTop, Point rightBottom) {
        this.points[0] = leftTop;
        this.points[1] = new Point(rightBottom.getX(), leftTop.getY());
        this.points[2] = rightBottom;
        this.points[3] = new Point(leftTop.getX(), rightBottom.getY());
        this.width = rightBottom.getX() - leftTop.getX();
        this.height = rightBottom.getY() - leftTop.getY();
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public void draw() {
        System.out.printf("네 꼭지점이 (%d, %d), (%d, %d), (%d, %d), (%d, %d)이고, 너비가 %d, 높이가 %d 사각형을 그린다.\n",
                    points[0].getX(), points[0].getY(),
                    points[1].getX(), points[1].getY(),
                    points[2].getX(), points[2].getY(),
                    points[3].getX(), points[3].getY(),
                    width,
                    height
                );
    }
}
