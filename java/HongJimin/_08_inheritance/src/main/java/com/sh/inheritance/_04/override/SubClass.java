package com.sh.inheritance._04.override;

public class SubClass extends SuperClass{
    @Override
    public void method(int num) {
        System.out.println("SubClass#method");
    }

//    @Override
//    private void privateMethod() {} //안됨

//    @Override
//    public final void finalMethod(){}

    @Override
    public void protectedMethod() {
        System.out.println("SubClass#protexted@Method");
    }
}


