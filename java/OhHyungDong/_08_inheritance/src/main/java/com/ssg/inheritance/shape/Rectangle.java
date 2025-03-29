package com.ssg.inheritance.shape;

import org.w3c.dom.css.Rect;

public class Rectangle extends Shape
{
    Point[] point = new Point[4];
    // 0번지 LeftTop  1번지 RightTOp,
    // 2번지 RightBottom 3번지 LeftBottom
    private int width ;
    private int height;

    public Rectangle(){}

    //point 자체를 다 받는 생성자
    public Rectangle(Point[] point){
        this.point = point;
      }


    // 생성자 : lefttop과 넓이, 높이를 받는 생성자
    public Rectangle(Point leftTop, int width, int height){
        this.point[0] = leftTop; // (0,0)
        this.point[1] = new Point(leftTop.x + width, leftTop.y); // rightTop(200,0)
        this.point[2] = new Point(leftTop.x + width, leftTop.y + height);//(200,100)//rightBottom
        this.point[3] = new Point(leftTop.x, height + leftTop.y); // leftBottom (0,100)


    }
    //생성자 : leftTop과 rightBottom을 받는 생성자
    public Rectangle(Point leftTop, Point rightbottom) //0,0 , 200, 100
    {
        this.point[0] = leftTop;
        this.point[2] = rightbottom;
        this.point[1] = new Point(rightbottom.x - leftTop.x,leftTop.y); //rightTop : 200 - 0 ( 200,0)
        this.point[3] = new Point(leftTop.x, rightbottom.y);


    }
    public double getArea(){
        return (this.point[2].x - this.point[0].x) * (this.point[2].y - this.point[0].y);
    }

    public void draw(){
        System.out.println("네 꼭지점이 (" +
                point[0].x + "," + point[0].y + ")," +
                "("+point[1].x + "," + point[1].y + ")," +
                "("+point[2].x + "," + point[2].y + ")," +
                "("+point[3].x + "," + point[3].y +
                ")이고 너비는 " + width + ", 이고 높이는 " + height + "인 사각형을 그린다 ")  ;
    }

}
