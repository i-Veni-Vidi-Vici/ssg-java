package com.sh.inheritance._04.override;

/**
 * <pre>
 * Overriding 오버라이딩
 * - 부모클래스의 메소드를 자식 클래스에서 재정의 하는 것.
 *
 * 성립조건
 * 1. 메소드명이 같아야 한다.
 * 2. 메소드 리턴타입이 같아야 한다.
 * 3. 매개변수부(타입, 개수, 순서)가 같아야 한다.
 * 4. 접근제한자는 부모 메소드와 같거나 더 개방적이어야 한다.
 *      - |private[접근불가]| - default - protected - public
 *      - 자식클래스에서 보다 사용하기 좋게 변경하는 것.
 * 5. (지금 배울 내용은 아님) 선언된 예외는 부모 메소드와 같거나 더 구체적 또는 더 적은 개수만 가능하다.
 *
 * 오버라이딩 불가한 경우
 * - final 메소드 오버라이드 불가
 * - private 메소드는 접근할 수 없어서 오버라이드 불가
 *
 * </pre>
 */

public class SuperClass {
    public void method(int num) {}

    /**
     * <pre>
     * 클래스내부에서만 호출하는 메소드(외부에 노출할 필요 없음)
     * private메소드 오버라이드 불가
     * </pre>
     */
    private void privateMethod() {}

    /**
     * <pre>
     * 종단메소드
     * - 부모에서 주어진 그대로 사용해야 메소드
     * - 변경 방지
     * </pre>
     */
    public final void finalMethod() {}

    protected void protectedMethod() {}
}
