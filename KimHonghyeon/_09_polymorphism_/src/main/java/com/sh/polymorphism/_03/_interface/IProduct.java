package com.sh.polymorphism._03._interface;

public interface IProduct {
    //public static final int MAX_NUM = 100;
    int MAX_NUM = 100; // 인터페이스 내 변수는 모두 자동으로 상수취급
    //public abstract void printInfo();
    public void printInfo(); //안터페이스 내 메소드는 모두 자동으로 추상메소드 취급

    /**
     * default 메소드: 자식 객체(구현체)에게 상속가능한 일반(정의된) 메소드
     */
    public default void defaultMethod(){
        System.out.println("디폴트 메소드 호출");
    }
    public static void staticMethod(){
        System.out.println("IProduct.staticMethod");
    }
}
