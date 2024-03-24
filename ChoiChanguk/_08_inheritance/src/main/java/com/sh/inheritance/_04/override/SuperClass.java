package com.sh.inheritance._04.override;

public class SuperClass {
    public void method(int num)
    {

    }

    /**
     * 클래서 내부에서만 호출하는 메소드(외부에 노출할 필요가 없음) + 있으면 뭘 써야 할지 모르니깐 감춤
     * private 메소드 오버라이드 불가
     *
     */
    private void privateMethod()
    {

    }

    /**
     * 종단메소드
     *  - 부모에서 주어진 그대로 사용해야 메소드
     *  - 변경을 방지
     */
    public final void finalMethod() {

    }

    protected void protectedMethod() {
    }

}
