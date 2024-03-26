package com.ssg.inheritance.shape;

public class ShapeMain {

    public static void main(String[] args) {
        // circle1
        Circle circle = new Circle(new Point(100, 100), 10);
        circle.draw();
        System.out.println("원의 넓이는 " + circle.getArea() + "입니다.");

        // rect1
        Point[] points = {
                new Point(0,0),
                new Point(200,0),
                new Point(200,100),
                new Point(0,100)
        };
        Rectangle rect = new Rectangle(points);
        rect.draw();
        System.out.println("사각형의 넓이는 " + rect.getArea() + "입니다.");

        // rect2, rect3
        // 아래 생성자도 동일하게 처리되어야 한다.
        Rectangle rect2 = new Rectangle(new Point(0,0), 200, 100);
        rect2.draw();
        System.out.println("사각형의 넓이는 " + rect2.getArea() + "입니다.");

        Rectangle rect3 = new Rectangle(new Point(0,0), new Point(200,300));
        rect3.draw();
        System.out.println("사각형의 넓이는 " + rect3.getArea() + "입니다.");

        System.out.println("shape(부모)에 Rectangle(자식)을 넣습니다");
        Shape shape1 = new Rectangle(new Point(0,0), 250, 150);
        shape1.draw();
        //Object toString은 기본적으로 현재 객체의 해쉬코드 정보를 반환한다

        System.out.println(circle);
        System.out.println(shape1);

        System.out.println("\ntoString Overriding "+rect2);
        System.out.println("\ntoString Overriding "+rect3);

    }
}