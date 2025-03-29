package com.sh.inheritance._04.override;

/**
 * <pre>
 * 오버라이딩(Override) 성립조건
 * - 부모클래스의 메서드를 자식클래스에서 재정의 하는 것.
 *
 * 성립 조건
 * 1. 메서드명이 같아야 함
 * 2. 메서드 리턴타입이 같아야 함
 * 3. 매개변수부(타입, 개수, 순서)가 같아야 한다.
 * 4. 접근제한자는 부모메서드와 같거나 더 개방적이어야 한다.
 *      - (default ->) protected -> public
 *      - 자식클래스에서 보다 사용하기 좋게 변경하는 것
 * 5. 선언된 예외는 부모메서드와 같거나 더 구체적(자식타입) 또는 더 적은 개수만 가능
 *
 * 오버라이딩 불가한 경우
 * - final메서드 오버라이드 불가
 * - private메서드는 접근할 수 없어서 오버라이드 불가
 *
 * </pre>
 */
public class SuperClass {

    public void method(int num) {

    }

    /**
     * 클래스내부에서만 호출하는 메서드(외부에 노출할 필요 없음)
     */
    private void privateMethod() {

    }

    public final void finalMethod() {

    }

    protected void protectedMethod() {

    }
}
