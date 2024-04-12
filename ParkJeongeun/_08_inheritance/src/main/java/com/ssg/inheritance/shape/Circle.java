package com.ssg.inheritance.shape;

public class Circle extends Shape{
//    Point point[] = new Point[2]; (나)
    private Point center; //has a 포함관계

    private int r;
    public Circle(Point center, int r){
//        (나)
//        point.getX();
//        point.getY();
        this.center = center;
        this.r = r;
    }
    @Override
    public double getArea() {
        double a = (Math.PI * r * r) * 1000000;
        double b = Math.round(a);
        double c = b / 1000000.0;
        return c;
    }

    @Override
    public void draw() {
//        (나)
//        String result = """
//                중심점이 (%d, %d)이고, 반지름이 %d인 원을 그린다.
//                """.formatted(point[0].getX(), point[1].getY(), this.r);
//        System.out.println(result);
//        (모범답안)
//        System.out.println("중심점이 (" + center.getX() + ", " + center.getY() + ")이고, 반지름이 " + r + "인 원을 그린다.");
        System.out.println("중심점이 " + center.toString() + "이고, 반지름이 " + r + "인 원을 그린다.");
    }
}
