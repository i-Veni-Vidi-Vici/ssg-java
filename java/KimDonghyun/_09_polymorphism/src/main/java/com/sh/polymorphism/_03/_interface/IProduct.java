package com.sh.polymorphism._03._interface;

public interface IProduct {
//    public static final int MAX_NUM = 100;
    int MAX_NUM = 100;
//    public abstract void printInfo();
    void printInfo();
    
    // 일반 메소드를 작성할 수 없다.
//    public void method(){}
    /**
     * 자식객체에 물려줄수 있는 일반메소드 - default메소드
     */
    public default void defaultMethod(){
        System.out.println("IProduct#defaultMethod 호출!!!");
    }

    /**
     * static메소드는 객체생성없이 사용가능
     */
    public static void staticMethod(){
        System.out.println("IProduct.staticMethod 호출!!!");
    }
}
