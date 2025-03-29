package com.sh.inheritance._04.override;

public class SubClass extends SuperClass {
    @Override
    void method(int num) {
        System.out.println("SubClass#method");
    }

    /*@Override
    private void privateMethod(){}*/
//    @Override
//    public final void finalMethod();
    @Override
    protected void protectedMethod(){
        System.out.println("SubClass#protectedMethod");
    }
}
