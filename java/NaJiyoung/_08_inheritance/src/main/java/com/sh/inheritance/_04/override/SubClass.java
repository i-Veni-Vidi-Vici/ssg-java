package com.sh.inheritance._04.override;

public class SubClass extends SuperClass {
    @Override
    public void method(int num) {
        System.out.println("SubClass#method");
    }

//    @Override
//    private void privateMethod() {}

    // overridden method is final
//    @Override
//    public final void finalMethod() {}

    @Override
//    protected void protectedMethod() {
    public void protectedMethod() {
        System.out.println("SubClass#protectedMethod");
    }
}
