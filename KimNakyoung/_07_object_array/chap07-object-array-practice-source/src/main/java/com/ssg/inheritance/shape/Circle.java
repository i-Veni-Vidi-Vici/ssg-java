package com.ssg.inheritance.shape;

public class Circle extends Shape{
    Point point = new Point();
    int r;




    public Circle(Point point,int r) {
        this.point = point;
        this.r = r;


    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public double getArea(){
        return r * r * Math.PI;
    }


     @Override
    public  void draw(){
         System.out.printf("중심점이 (%d,%d)이고, 반지름이 %d인 원을 그린다.\n",point.getX(),point.getY(),r);
     }

}
