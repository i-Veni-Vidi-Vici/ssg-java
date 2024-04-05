package com.sh.lambda_01.inner._class;

public class App {
    public static void main(String[] args) {
        // static 내부클래스 객체 생성
        Outer.Inner1 instance1 = new Outer.Inner1();
        instance1.a(); // 99

        // non-static 내부클래스 객체 생성
        Outer outer = new Outer();
        Outer.Inner2 instance2 = outer.new Inner2();
        instance2.a(); // 99, 100

        // 외부에서 지역 내부클래스에 접근하는 방법은 없음 (test메소드 안의 a)
        // 애초에 목적이 메소드 안에서만 사용
        outer.test();
    }
}
