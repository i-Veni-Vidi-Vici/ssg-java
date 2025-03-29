package com.sh.inheritance._04.override;

public class SubClass extends SuperClass {
    @Override
    public void method(int number) {
        System.out.println("SubClass#method");
    }

    // @Override
    // protected void protectedMethod() {}

    @Override
    public void protectedMethod() {
        System.out.println("SubClas#protectedMethod");
    }
}
