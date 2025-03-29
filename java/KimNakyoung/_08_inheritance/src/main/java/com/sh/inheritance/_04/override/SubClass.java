package com.sh.inheritance._04.override;

public class SubClass extends SuperClass {

    @Override
    public void method(int nummmmmm) {
        System.out.println("서브클래스의 메소드");
    }

//    @Override
//    private void privateMethod(){
//
//    }
    // private 메소드 안됨

    /**
     * <pre>
     *  종단메소드
     *  - 부모에서 주어진 그대로 사용하는 메소드
     *  - 변경 방지
     * </pre>
     *
     */

//    @Override
//    public final void finalMethod(){}

    @Override
    public void protectedMethod(){
        System.out.println("SubClass#protectedMethod");
    } // 가능

}
