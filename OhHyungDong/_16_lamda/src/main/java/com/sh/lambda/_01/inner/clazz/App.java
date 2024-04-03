package com.sh.lambda._01.inner.clazz;

/**
 * <pre>
 *  내부 클래스
 *  - 클래스 안에 선언된 클래스
 *  - 외부 클래스 안에서만 사용할 목적을 만들어진 클래스
 *  - 연관된 클래스를 그룹핑하기 위해서도 사용한다.
 *
 *
 * 종류
 * 1. static 내부 클래스 - 클래스 영역의 static 자원
 * 2. non-static 내부 클래스 - 클래스 영역의 non - static 자원
 * 3. 지역 내부 클래스 - 메소드 안의 지역변수처럼 선언
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        //static 내부 클래스 객체 생성
        Outer.Inner1 instance = new Outer.Inner1();
        instance.a();

        //non-statc inner class 객체 생성
        Outer outer = new Outer();
        Outer.Inner2 instance2 = outer.new Inner2();
        instance2.a();

        // 외부에서 지역 내부 클래스에 접근하는 방법은 없다.
        outer.test();
    }

}
