package com.sh.inheritance._04.override;

/**
 *<pre>
 *
 *</pre>
 *
 * 클래스 내부에서만 호출하는 메소드(외출
 * private 메소드 오버라이드 불가
 */
public abstract class SuperClass {
    public void method(int num) {}

    /**
     * 클래스 내부에서만 호출하는 메ㅗ드(외부에 노출할 필요 없음)
     */
    private void privateMethod() {}

    /**
     * 종단 메소드
     * - 부모에서 주어진 그대로 사용해야 하는 메소드
     * - 변경 방지
     */
    public final void finalMethod() {}

    protected void protectedMethod() {}


}
