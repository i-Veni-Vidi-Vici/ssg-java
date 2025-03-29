package com.sh.inheritance._04.override;

public class SubClass extends  SuperClass {
    @Override
    public void method(int n) {
        System.out.println("SubClass#method");
    }

//    @Override
//    private void privateMethod() {}

//    @Override
//    public final void finalMethod() {} // final이 붙어있기 때문에 바꾸지 말고 그대로 써


    @Override
//    protected void protectedMethod() {
//        System.out.println("SubClass#protectedMethod");
//    }
    public void protectedMethod() { // protected 에서 public으로 범위를 넓힐 수 있음
        System.out.println("SubClass#protectedMethod");
    }
}
