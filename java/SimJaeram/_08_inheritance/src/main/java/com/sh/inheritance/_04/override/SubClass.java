package com.sh.inheritance._04.override;

public class SubClass extends SuperClass {

    @Override
    public void method(int num) { // 오버라이드 할때 매개변수 이름 바껴도 상관 없음
        System.out.println("SubClass#method");
    }

//    @Override
//    private void privateMethod() {
//
//    }
//
//    @Override
//    public final void finalMethod() {
//
//    }

    @Override

    protected void protectedMethod() {
//    public void protectedMethod() {

    }
}
