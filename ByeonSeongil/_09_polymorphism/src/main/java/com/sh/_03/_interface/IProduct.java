package com.sh._03._interface;


interface IProduct {
    //    public  static  final int MAX_NUM =100;
    int MAX_NUM = 100;
    // public abstract void printInfo();

    void printInfo();

    // 일반메서드르 작성x
    // public void method(){}

    /**
     * 자식객체에 물려줄수 있는 일반메서드 - default 메서드
     */

    default void defaultMethod() {
        System.out.println("디폴트 메서드");

    }

    /**
     * static메서드는 객체생성없이 사용가능
     */
    public static void staticMethod() {
        System.out.println("IProduct#defaultMethod");
    }




}
