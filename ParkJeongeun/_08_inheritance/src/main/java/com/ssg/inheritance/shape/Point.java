package com.ssg.inheritance.shape;

public class Point {
    private int x;
    private int y;

    public Point() {}

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * 객체의 정보를 문자열로 변환 :
     * - Object#toString() -> "클래스풀네임@해시코드"
     * - 자식클래스에서 필드정보를 확인할수 있도록 오버라이드하고 있음.
     * - toString을 명시적으로 호출하지 않아도, 문자열로 출력되어야 하는 경우 자동으로 호출!
     * @return
     */
    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
