package com.sh.inheritance._04.override;

/**
 * <pre>
 *  오버라이딩(Override)  (메소드 오버라이딩)
 *  - 부모클래스의 메소드를 자식클래스에서 재정의 하는 것
 *
 *  성립조건

 *  1. 메소드명이 같아야 한다.
 *  2. 메소드 리턴타입이 같아야 한다.
 *  3. 매개변수부(타입, 개수,순서)가 같아야 한다.
 *  ~ public void test(int a, String s) {}  이거 같아야 한다!! ~
 *  4. 접근제한자는 부모메소드와 같거나 더 개방적이여야 한다.
 *      - (default ->) protected -> public
 *      - 자식클래스에서 보다 사용하기 좋게 변경하는 것
 *  5. 선언된 예외는 부모메소드와 같거나 더 구체적(자식타입) 또는 더 적은 개수만 가능하다.
 *
 *  오버라이딩 불가한 경우
 *  - final메소드 오버라이딩 불가
 *  - private메소드는 접근할 수없어서 오버라이드 불가
 *
 * </pre>
 *
 *
 */


public class SuperClass {


    public void method(int num) {}

    private void privateMethod() {}


    // 바꿔쓰지마 final은 정해진거니까 쓰기만 해
    public final void finalMethod() {}

    protected void protectedMethod(){}

}
