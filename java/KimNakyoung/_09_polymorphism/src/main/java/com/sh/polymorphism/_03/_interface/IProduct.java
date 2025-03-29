package com.sh.polymorphism._03._interface;


// public class 대신에 interface
public interface IProduct {
//    public static final int MAX_NUM = 100;

    int MAX_NUM = 100; // 이렇게 써도 똑같다

//    public abstract void printInfo();

    void printInfo(); // 이렇게 써도 추상메소드

    // 일반 메소드를 작성할 수 없다.
    // public void method(){}

    /**
     *
     * 자식 객체에 물려줄 수 있는 일반 메소드 - default 메소드
     */

    public default void defaultMethod(){
        System.out.println("IProduct#defaultMethod 호출!!");
    }

    public static void staticMethod(){
        System.out.println("ddd");
    }


}
