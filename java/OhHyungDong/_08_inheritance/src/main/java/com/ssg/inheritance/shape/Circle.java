package com.ssg.inheritance.shape;

public class Circle extends Shape{


    //중심점 x,y 와 반지름의 길이 변수 설정
    private int radius;
    Point point; //중심점 변수
    @Override
    public double getArea(){
        return radius * radius * Math.PI;
    }

    //중심점과 반지름을 포함하는 Circle의 생성자 생성
    public Circle(Point point, int radius){
        this.point = point;
        this.radius = radius;
    }

    @Override
    public void draw(){
        System.out.println("중심점이 (" + point.x +","+ point.y +")이고 반지름이 " + radius +"인 원을 그린다.");
    }
    public Circle() {
    }



    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }


}
