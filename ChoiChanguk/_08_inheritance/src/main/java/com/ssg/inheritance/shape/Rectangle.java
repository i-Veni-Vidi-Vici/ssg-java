package com.ssg.inheritance.shape;

public class Rectangle extends Point{
    Point[] points=new Point[4];
    private int width;
    private int height;

    public Rectangle() {

    }
    public Rectangle(Point[] points)
    {
        this.points[0]=points[0];
        this.points[1]=points[1];
        this.points[2]=points[2];
        this.points[3]=points[3];
        width=points[1].getX()-points[0].getX();
        height=points[2].getY()-points[0].getY();

    }
    public Rectangle(Point leftTop, int width, int height)
    {
        this.points[0]=leftTop;
        this.points[1]=new Point(leftTop.getX()+width,0);
        this.points[2]=new Point(leftTop.getX()+width,leftTop.getY()+height);
        this.points[3]=new Point(leftTop.getX(),leftTop.getY()+height);
        this.width=width;
        this.height=height;

    }
    public Rectangle(Point leftTop, Point rightBottom)//(0,0)
    {
        this.points[0]=leftTop;
        this.points[1]=new Point(leftTop.getX()+rightBottom.getX(),0);
        this.points[2]=rightBottom;
        this.points[3]=new Point(0,leftTop.getY()+rightBottom.getY());
        width=rightBottom.getX()-leftTop.getX();
        height=rightBottom.getY()-leftTop.getY();

    }

    public void draw() {
        System.out.printf("네 꼭지점이 (%d, %d), (%d, %d), (%d, %d), (%d, %d)이고, 너비 : %d, 높이 : %d\n"
        ,points[0].getX(),points[0].getY(),points[1].getX(),points[1].getY(),
                points[2].getX(),points[2].getY(),points[3].getX(),points[3].getY(),
                width,height);

    }

    public String getArea() {
        return "사각형의 너비는 : "+(double)width*height+"입니다";
    }
}
