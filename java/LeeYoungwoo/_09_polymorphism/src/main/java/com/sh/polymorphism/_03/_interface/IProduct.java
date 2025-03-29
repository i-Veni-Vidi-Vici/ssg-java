package com.sh.polymorphism._03._interface;

public interface IProduct {
//    public static final int MAX_NUM = 100;
    int MAX_NUM = 100; // 위처럼 안써도 어짜피 interface이기 때문에 안적어도 상수라고 알아먹음
//    public abstract void printInfo();
    void printInfo(); //위처럼 안써도 어짜피 interface이기 때문에 안적어도 추상메소드라고 알아먹음

    // 일반 메소드를 작성할 수 없다.
//    public void method(){}

    /**
     * 자식 객체에 물려줄 수 있는 일반 메소드 - default 메소드
     */
    public default void defaultMethod(){
        System.out.println("IProduct#defaultMethod 호출!!!");
    }

    /**
     * static 메소드는 객체생성없이 사용가능
     */
    public static void staticMethod() {
        System.out.println("IProduct.staticMethod 호출!!!");
    }
}
