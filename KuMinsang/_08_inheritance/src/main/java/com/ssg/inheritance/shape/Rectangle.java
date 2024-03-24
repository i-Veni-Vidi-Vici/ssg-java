package com.ssg.inheritance.shape;

public class Rectangle extends Shape{
    private Point[] points = new Point[4];

    public Rectangle() {
    }

    public Rectangle(Point[] points) {
        this.points = points;
    }

    public Rectangle(Point leftTop, int width, int height) {
        this.points[0] = leftTop;

        this.points[1] = new Point(leftTop.getX()+width,leftTop.getY());
        this.points[2] = new Point(leftTop.getX()+width, leftTop.getY()+height);
        this.points[3] = new Point(leftTop.getX(), leftTop.getY()+height);

    }
    public Rectangle(Point leftTop, Point rightBottom) {

        this.points[0] = leftTop;
        this.points[1] = new Point(rightBottom.getX(),leftTop.getY());
        this.points[2] = rightBottom;
        this.points[3] = new Point(leftTop.getX(),leftTop.getY()+rightBottom.getY());

    }

    @Override
    public void draw() {    //“네 꼭지점이 (0, 0), (200, 0), (200, 100), (0, 100)이고, 너비가 200, 높이가 100인 사각형을 그린다.”
        System.out.printf("네 꼭지점이 (%d, %d), (%d, %d), (%d, %d), (%d, %d)이고, 너비가 %d, 높이가 %d인 사각형을 그린다.",
                points[0].getX(), points[0].getY(),points[1].getX(), points[1].getY(),points[2].getX(), points[2].getY(),points[3].getX(), points[3].getY(), points[1].getX()-points[0].getX(), points[3].getY()-points[0].getY() );
    }

    @Override
    public double getArea() {   //사각형의 넓이 반환
        return (points[1].getX()-points[0].getX()) * (points[3].getY()-points[0].getY());
    }
}
