package com.sh.ineritance._04.override;

/**
 * <pre>
 *  오버라이딩 성립 조건
 *  - Override
 *  - 부모 클래스의 메소드를 자식 클래스에서 재정의 해서 쓰는 것
 *
 *  성립 조건
 *  1. 메소드명이 같아야 한다.
 *  2. 메소드 리턴 타입이 동일해야한다.
 *  3. 메소드의 파라미터 순서와 자료형이 동일해야한다.
 *  4. 접근제한자는 부모메소드와 같거나 더 개방적이어야 한다.
 *       - default -> protected -> public
 *       - 자식 클래스에서 보다 사용하기 좋게 변경하는 것
 *  5. 선언된 예외는 부모 메소드와 같거나 더 구체적 또는 더 적은 개수만 가능하다.
 *
 *  오버라이딩 불가한 경우
 *  - final 메소드 오버라이드 불가
 *  - private메소드는 접근할 수 없어서 오버라이드 불가
 * </pre>
 */
public class SuperClass {

    public void method(int num){}

    /**
     * 클래스 내부에서만 호출하는 메솓(외부에 노출할 필요 없음)
     * private method - override x
     * final method - override x
     */
    private void privateMethod(){}

    /**
     * <pre>
     *  종단 메소드
     *  - 부모에서 주어진 그대로 사용해야하는 메소드
     *  - 변경을 방지 하는 메소드
     * </pre>
     */
    public final void finalMethod(){}

    protected  void protectedMethod(){}

}
