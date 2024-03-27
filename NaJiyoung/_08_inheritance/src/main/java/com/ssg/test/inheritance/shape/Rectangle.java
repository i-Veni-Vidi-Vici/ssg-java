package com.ssg.test.inheritance.shape;

public class Rectangle extends Shape{
    private Point[] points; // has-a 포함관계
    private int width;
    private int height;

    public Rectangle() {}
    public Rectangle(Point[] points, int width, int height) {
        this.points = points;
        this.width = width;
        this.height = height;
    }

    public Rectangle(Point[] points) {  // 모든 점의 좌표 값을 points 객체 배열에 직접 넣었을 때
        this.points = points;
        width = points[1].getX() - points[0].getX();
        height = points[3].getY() - points[0].getY();
    }
    public Rectangle(Point leftTop, int width, int height) {    // 왼쪽 위 꼭짓점(points[0])의 좌표 값과 너비, 높이를 넣었을 때
        points = new Point[4];
        points[0] = leftTop;
        points[1] = new Point(leftTop.getX()+width, leftTop.getY());
        points[2] = new Point(leftTop.getX()+width, leftTop.getY()+height);
        points[3] = new Point(leftTop.getX(), leftTop.getY()+height);
        this.width = width;
        this.height = height;
    }
    public Rectangle(Point leftTop, Point rightBottom) {    // 왼쪽 위 꼭짓점(points[0])의 좌표값, 오른쪽 아래 꼭짓점(points[2])의 좌표 값만 넣었을 때
        this.width = rightBottom.getX() - leftTop.getX();
        this.height = rightBottom.getY() - leftTop.getY();
        points = new Point[4];
        points[0] = leftTop;
        points[1] = new Point(leftTop.getX()+width, leftTop.getY());
        points[2] = rightBottom;
        points[3] = new Point(leftTop.getX(), leftTop.getY()+height);
    }

    @Override
    public void draw() {
        System.out.println("네 꼭지점이 "+ points[0] + ", " + points[1] + ", " + points[2] + ", " + points[3] + "이고, 너비가 " + width + ", 높이가 " + height + "인 사각형을 그린다.");
    }

    @Override
    public double getArea() {
        return width * height;
    }
}
