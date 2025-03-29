package com.sh.polymorphism._03._interface;

public interface IProduct {
    //
    // public static final int MAX_NUM=100 // ==int MAX_NUM=100;
    int MAX_NUM=100;
    //public abstract void printInfo(); == // void printInfor()
    void printInfo();

    //일반 메소드를 작성할 수 없다.
    //public void method();
        /**
         * 자신객체에 물려줄 수 있는 애만 메소드 - defaultMethod메소드 호출
         */


    public default void defaultMethod(){};
    public static void staticMethod(){
        System.out.println("static 호출");;
    }

}
