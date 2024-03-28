package com.ssg.inheritance.shape;

public class Rectangle extends Shape{

    private Point[] points = new Point[4];
    private int width; // 너비
    private int height; // 높이

    public Rectangle() {}
    public Rectangle(Point[] points){
        // super() 부모 Shape쓰려면 자동으로 생김. 생략가능하지만 자동으로 들어가있음
        this.points = points; // this.points배열에 ShapeMain에서 호출한 new point(x,y)값 차례대로 대입
        this.width = points[1].getX() - points[0].getX();
        this.height = points[3].getY() - points[0].getY();
    }
    public Rectangle(Point leftTop, int width, int height){
        points[0] = leftTop;
        points[1] = new Point(leftTop.getX() + width, leftTop.getY());
        points[2] = new Point(leftTop.getX() + width, leftTop.getY() + height);
        points[3] = new Point(leftTop.getX(), leftTop.getY() + height);
        this.width = width;
        this.height = height;
    }
    public Rectangle(Point leftTop, Point rightBottom){
        this.width = rightBottom.getX()-leftTop.getX();
        this.height = rightBottom.getY()-leftTop.getY();
        points[0] = leftTop;
        points[1] = new Point(leftTop.getX() + width, leftTop.getY());
        points[2] = rightBottom;
        points[3] = new Point(leftTop.getX(), leftTop.getY() + height);
    }

    @Override
    public void draw() {
        System.out.printf("네 꼭지점이 (%d, %d), (%d, %d), (%d, %d), (%d, %d)이고, 너비가 %d, 높이가 %d인 사각형을 그린다.\n",
                points[0].getX(), points[0].getY(),
                points[1].getX(), points[1].getY(),
                points[2].getX(), points[2].getY(),
                points[3].getX(), points[3].getY(),
                this.width,this.height
        );
    }

    @Override
    public double getArea() {
        return width * height;
    }
}
