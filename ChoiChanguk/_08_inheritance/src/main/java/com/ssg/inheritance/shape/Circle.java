package com.ssg.inheritance.shape;

public class Circle extends Point{
    private int r;//반지름



    public Circle( Point point,int r) {
        super(point.getX(), point.getY());
        this.r = r;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public void draw() {
        System.out.printf("중심점이 (%d, %d)이고, 반지름이 %d인 원을 그린다\n",this.getX(),this.getY(),r);
    }
    public double getArea()
    {
        return r*r*Math.PI;
    }
}
