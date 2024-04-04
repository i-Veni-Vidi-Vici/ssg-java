package com.ssg.inheritance;

public class ShapeMain {
    public static void main(String[] args) {
        // circle
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

        Rectangle rect3 = new Rectangle(new Point(0,0), new Point(200,100));
        rect3.draw();
        System.out.println("사각형의 넓이는 " + rect3.getArea() + "입니다.");

        /**
         *
         * 네 꼭지점이 (0, 0), (200, 0), (200, 100), (0, 100)이고, 너비가 200, 높이가 100인 사각형을 그린다.
         * 사각형의 넓이는 20000.0입니다.
         * 네 꼭지점이 (0, 0), (200, 0), (200, 100), (0, 100)이고, 너비가 200, 높이가 100인 사각형을 그린다.
         * 사각형의 넓이는 20000.0입니다.
         * 네 꼭지점이 (0, 0), (200, 0), (200, 100), (0, 100)이고, 너비가 200, 높이가 100인 사각형을 그린다.
         * 사각형의 넓이는 20000.0입니다.
         */
    }
}
