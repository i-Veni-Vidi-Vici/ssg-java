package com.ssg.inheritance;

public class Rectangle extends Shape{
    private Point point;
    private int width;
    private int height;
    private Point [] points = {new Point(0, 0), new Point(0, 0),new Point(0, 0),new Point(0, 0)};

    public Rectangle() {
    }

    public Rectangle(Point[] newPoints) {
        this.points = newPoints;
        this.width = this.points[1].getX() - this.points[0].getX();
        this.height = this.points[2].getY() - this.points[0].getY();
    }
    public Rectangle(Point point, int width, int height) {
        this.points[0] = point;
        this.points[1] = new Point(point.getX() + width, point.getY());
        this.points[2] = new Point(point.getX() + width, point.getY() + height);
        this.points[3] = new Point(point.getX(), point.getY() + height);
        this.width = width;
        this.height = height;
    }

    public Rectangle(Point point1, Point point2) {
        this.points[0] = point1;
        this.points[1] = new Point(point1.getX()+width, point1.getY());
        this.points[2] = point2;
        this.points[3] = new Point(point1.getX(), point1.getY() + height);
        this.width = Math.abs(point1.getX()-point2.getX());
        this.height = Math.abs(point1.getY() - point2.getY());
    }

    @Override
    public double getArea() {
        return this.width * this.height;
    }

    @Override
    public void draw() {
        System.out.println("네 꼭지점이" +
                        "(" + this.points[0].getX() + ", " + this.points[0].getY() + "), " +
                        "(" + this.points[1].getX() + ", "+ this.points[1].getY() + "), " +
                        "(" + this.points[2].getX() + ", "+ this.points[2].getY() + "), " +
                        "(" + this.points[3].getX() + ", "+ this.points[3].getY() + ")이고, " +
                 "너비가 " + this.width + ", 높이가 " + this.height + "인 사각형을 그린다." );
    }
}
