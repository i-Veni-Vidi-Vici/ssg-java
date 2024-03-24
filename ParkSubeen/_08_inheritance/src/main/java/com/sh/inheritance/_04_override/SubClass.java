package com.sh.inheritance._04_override;

public class SubClass extends SuperClass {

    @Override
    public void method(int num) {
        System.out.println("SubClass#method");
    }

//    @Override
//    private void privateMethod() {}

    // overridden method is final
//    @Override
//    public final void finalMethod() {} // 'finalMethod()' cannot override 'finalMethod()' in 'com.sh.inheritance._04_override.SuperClass'; overridden method is final

    @Override
//    protected void protectedMethod() {
    public void protectedMethod() {
        System.out.println("SubClass#protectedMethod");
    }
}
