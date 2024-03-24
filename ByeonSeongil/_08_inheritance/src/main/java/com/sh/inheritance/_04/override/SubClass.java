package com.sh.inheritance._04.override;

public class SubClass extends SuperClass{

    @Override
    public void method(int num1) {
        System.out.println("SubClass#method");
    }

    /**
     * <pre>
     * private메서드 오버라이드 불가
     * </pre>
     */
//    @Override
//    private void privateMethof() {
//
//    }

    /**
     * <pre>
     * 종단메서드
     * - 부모에서 주어진 그대로 사용해야하는 메서드
     * - 변경 방지
     * </pre>
     */
//    @Override
//    public final void finalMethod() {
//
//    }

    @Override
    protected void protectedMethod() {
        System.out.println("SubClass#protectedMethod");
    }
//    @Override
//    public void protectedMethod() {
////        System.out.println("SubClass");
//    }
}
