package com.ssg.inheritance.shape;

public class ShapeMain {

    public static void main(String[] args) {

        //circle
        Circle circle = new Circle(new Point(100,100),10);
        circle.draw();
        System.out.printf("원의 넓이는 %.4f 입니다.",circle.getArea());
        System.out.println();

        //rect1
        Point[] points = {
                new Point(0,0),//
                new Point(200,0),//1
                new Point(200,100),//2
                new Point(0,100)//3
        };
        System.out.println("첫번째 사각형 ");
        Rectangle rect = new Rectangle(points);
        rect.draw();
        System.out.println("사각형의 넓이는 " + rect.getArea() + "입니다. ");
        System.out.println();

        System.out.println("두번째 사각형 ");
        Rectangle rect2 = new Rectangle(new Point(0,0), 200, 100);
        rect2.draw();
        System.out.println("사각형의 넓이는 " + rect2.getArea() + "입니다.");
        System.out.println();

        System.out.println("세번째 사각형 ");
        Rectangle rect3 = new Rectangle(new Point(0,0), new Point(200,100));
        rect3.draw();
        System.out.println("사각형의 넓이는 " + rect3.getArea() + "입니다.");

    }
}
