package com.sh.polymorphism._03_interface;

public interface IProduct {
//    public static final int MAX_NUM = 100;
    int MAX_NUM = 100;  //final 없이 선언해도 final로 선언된다

//    public abstract void printInfo();
    void printInfo();   //이렇게만 선언해도 추상메소드로 선언

    /**
     * 자식 객체에 물려줄수 있는 일반 메소드 - default method
     *
     */
    public default void defaultmethod(){
        System.out.println("IProduct#defaultMethod 호출!!!");
    }

    public static void staticMethod(){
        System.out.println("IProduct. staticmthod");
    }

}
