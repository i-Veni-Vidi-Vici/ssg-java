package com.sh.polymorphism._03._interface;

public interface IProduct {
//    public static final int MAX_NUM = 100;
    int MAX_NUM = 100;  // 4줄과 같은 의미
//    public abstract void printInfo();
    void printInfo(); // 6줄과 같은 의미

    // 일반 메소드를 작성할 수 없다
//    public void method(){}

    /**
     * 자식객체에 물려줄 수 있는 일반메소드 - default메소드
     */
    public default void defaultMethod(){
        System.out.println("IProduct#defaultMethod 호출!!");
    }

    /**
     * static메소드는 객체생성없이 바로 사용 가능
     * 인터페이스 이름으로 static메소드 호출가능
     */
    public static void staticMethod(){
        System.out.println("IProduct.staticMethod 호출!!");
    }

}
