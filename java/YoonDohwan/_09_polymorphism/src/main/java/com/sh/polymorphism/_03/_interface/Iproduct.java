package com.sh.polymorphism._03._interface;

public interface Iproduct {
    //public static final
    int MAX_NUM=100;
    //public abstract
    void printInfo();
    //일반메소드를 작성할 수 없다.
    //public void method(){}
    /**
     * 자식객체에 물려줄수 있는 일반메소드 - default 메소드
     */
    public default void defaultMethod(){
        System.out.println("Iproduct#defaultMethod호출!!!");
    }
    public static void staticMethod(){
        System.out.println("Iproduct#staticMethod호출!!!");
    }
}
