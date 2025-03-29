package com.sh.inheritance._04.override;

/**
 * <pre>
 * 오버라이딩(Override) 성립조건
 * - 부모클래스의 메소드를 자식클래스에서 재정의 하는 것.
 * -
 * 성립조건
 * 1. 메소드명이 같아야 한다
 * 2. 메소드 리턴타입이 같아야 한다
 * 3. 매개변수부(타입, 개수, 순서)가 같아야 한다
 * 4. 접근제한자는 부모메소드와 같거나 더 개방적이어야 한다
 * 5. 선언된 예외는 부모메소드와 같거나 더 구체적(자식타입) 또는 더 적은 개수만 가능하다
 *          -private(접근이 불가니 예외) - defalut(이것도 거의 안씀) - protected - public
 *          - 자식클래스에서 보다 사용하기 좋게 변경하는 것
 *
 * 오바리이딩 불가한 경우
 *  - final 메소드 오버라이드 불가
 *  - private 메소드 접근할 수 없어서 오버라이드 불가
 *
 * </pre>
 */
public class SubClass extends SuperClass {

    @Override
    public void method(int num) {
        System.out.println("SubClassMethod입니다");
        super.method(num);
    }


    //protected -> protected 가능
    //protected -> public으로 가능
    @Override
    protected void protectedMethod() {
        System.out.println("SubClass#protectedMethod");
        super.protectedMethod();
    }
}
