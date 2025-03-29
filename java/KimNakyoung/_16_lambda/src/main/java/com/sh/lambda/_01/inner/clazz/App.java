package com.sh.lambda._01.inner.clazz;

public class App {
    public static void main(String[] args) {
        Outer.Inner1 instance1 = new Outer.Inner1();
        instance1.a();

        // non-static 내부클래스 객체 생성
        Outer outer = new Outer();
        outer.new Inner2();
        instance1.a();

        // 외부에서 지역내부클래스에 접근하는 방법은 없다.

    }
}
