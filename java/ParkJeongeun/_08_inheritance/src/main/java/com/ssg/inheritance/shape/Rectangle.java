package com.ssg.inheritance.shape;

public class Rectangle extends Shape{
//    (나)
//    Point points[] = new Point[4];
//    Point leftTop = points[0];
//    Point rightTop = points[1];
//    Point rightBottom = points[2];
//    Point leftBottom = points[3];

    private Point[] points;
    private int width;
    private int height;
    public Rectangle(Point[] points){
//        (나)
//        this.leftTop = points[0];
//        this.rightTop = points[1];
//        this.rightBottom = points[2];
//        this.leftBottom = points[3];
        this.points = points;
        this.width = points[1].getX() - points[0].getX();
        this.height = points[3].getY() - points[0].getY();
    }
    public Rectangle(Point leftTop, int width, int height){
//        (나)
//        this.leftTop = points[0];
        this.points = new Point[4];
        this.points[0] = leftTop;
        this.points[1] = new Point(leftTop.getX() + width, leftTop.getY());
        this.points[2] = new Point(leftTop.getX() + width, leftTop.getY() + height);
        this.points[3] = new Point(leftTop.getX(), leftTop.getY() + height);
        this.width = width;
        this.height = height;
    }
    public Rectangle(Point leftTop, Point rightBottom){
//        (나)
//        this.leftTop = points[0];
//        this.rightBottom = points[2];
        this.width = rightBottom.getX() - leftTop.getX();
        this.height = rightBottom.getY() - leftTop.getY();

        points = new Point[4];
        points[0] = leftTop;
        points[1] = new Point(leftTop.getX() + width, leftTop.getY());
        points[2] = rightBottom;
        points[3] = new Point(leftTop.getX(),leftTop.getY() + height);
    }

    @Override
    public double getArea() {
//        (나)
//        return rightTop.getX() * leftBottom.getY();
        return width * height;
    }

    @Override
    public void draw() {
//        (나)
//        String result = """
//                네 꼭지점이 (%d, %d), (%d, %d), (%d, %d), (%d, %d)이고, 너비가 %d, 높이가 %d인 사각형을 그린다.
//                """.formatted(leftTop.getX(), leftTop.getY(), rightTop.getX(), rightTop.getY(), rightBottom.getX());

        System.out.println("네 꼭지점이 " + points[0] + ", " + points[1] + ", " + points[2] + ", " + points[3] + "이고, 너비가 " + width + ", 높이가 " + height + "인 사각형을 그린다.");
    }
}
