package com.sh.inheritance._04.override;

public class SubClass extends SuperClass {
    @Override
    public void method(int num){
        System.out.println("SubClass#method");
    }

//    @Override
//    private void privateMethod(){} // private 메소드는 오버라이드 불가
//    public final void finalMethod(){} // final 메소드는 오버라이드 불가
    @Override
//    protected void protectedMethod(){ // 오버라이드 가능
    public void protectedMethod(){ // 더 개방적인 접근제한자 가능
        System.out.println("SubClass#protectedMethod");
    }
}
