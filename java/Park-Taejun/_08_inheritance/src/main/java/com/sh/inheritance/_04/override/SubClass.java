package com.sh.inheritance._04.override;

public class SubClass extends SuperClass {

    @Override
    public void method(int num) {
        System.out.println("SubClass#method");
    }

//    @Override
//    private void privateMethod(){} //private일서 접근 불가

//    public final void  finalMethod(){} 마찬가지로 final은 오버라이드 불가능함


    protected void protectedMethod() {
//    public void protectedMethod(){}
        System.out.println("SubClass#protectedMethod");
    }
}
