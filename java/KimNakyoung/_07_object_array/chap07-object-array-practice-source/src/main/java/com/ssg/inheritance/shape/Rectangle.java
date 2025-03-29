package com.ssg.inheritance.shape;

public class Rectangle extends Shape {
    Point point = new Point();

    int height; // 높이
    int width; // 넓이

    public Rectangle(Point[] points) {
        //첫번째 좌표로 초기화
        int minX = points[0].getX();
        int maxX = points[0].getX();
        int minY = points[0].getY();
        int maxY = points[0].getY();
        // 실제 값 넣어서 비교
        for (Point p : points){
            if (p.getX() < minX) minX = p.getX();
            if (p.getX() > maxX) maxX = p.getX();
            if (p.getY() < minY) minY = p.getY();
            if (p.getY() > maxY) maxY = p.getY();
        }
        this.point = new Point(minX,maxY);
        this.width = maxX - minX;
        this.height = maxY - minY;
    }


    public Rectangle(Point leftTop , int width,int height ) {
        this.point = leftTop;
        this.width = width;
        this.height = height;
    }


    public Rectangle(Point leftTop, Point rightBottom){
        this.point = leftTop;
        this.width = rightBottom.getX() - leftTop.getX();
        this.height = rightBottom.getY() -leftTop.getY();

    }

    @Override
    public void draw(){
        Point topRight = new Point(point.getX() + width, point.getY());
        Point bottomLeft = new Point(point.getX(), point.getY() + height);
        Point bottomRight = new Point(point.getX() + width, point.getY() + height);

        // 네 꼭지점 출력
        System.out.printf("네 꼭지점이 (%d,%d), (%d,%d), (%d,%d), (%d,%d)이고, 너비가 %d, 높이가 %d인 사각형을 그립니다.\n",
                point.getX(), point.getY(), // 왼쪽 상단
                topRight.getX(), topRight.getY(), // 오른쪽 상단
                bottomRight.getX(), bottomRight.getY(), // 오른쪽 하단
                bottomLeft.getX(), bottomLeft.getY(), // 왼쪽 하단
                width,height);
    }

    @Override
    public double getArea(){

        double square =(double) height * width;
        return square;
    }


}
