package com.sh.inheritance._04.override;

/**
 * 오버라이딩 성립조건
 * -부모클래스의 메소드를 자식클래스에서 재정의 하는 것.
 *
 * 성립조건
 * 1.메소드명이 같아야 한다.
 * 2.메소드 리턴타입이 같아야 한다.
 * 3.매개변수부(타입,개수,순서)가 같아야 한다.
 * 4.접근제한자는 부모메소드와 같거나 더 개방적이어야 한다.
 *  (-default ->)protected ->public
 *  * 자식클래스에서 더 좋게 사용하기 좋게 변경하는것
 * 5.선언된 예외는 부모메소드와 같거나 더 구체적 또는 더 적은 개수만 가능하다.
 *
 * 오버라이딩 불가한 경우
 * -final 메소드 오버라이드 불가
 * -private 메소드는 접근할수 없어서 오버라이드 불가
 *
 *
 *
 *
 *
 */
public class SuperClass {
    public void method(int num){}

    /**
     * 클래스내부에서만 호출하는 메소드(외부에 노출할 필요 없음)
     * private 메소드 오버라이드 불가
     *
     */
    private void privateMethod(){}

    /**
     * 종단메소드
     * -부모에서 주어진 그대로 사용해야 하는 메소드
     * 변경방지
     */
    public final void finalMethod(){}
    protected void protectedMethod(){}

}
