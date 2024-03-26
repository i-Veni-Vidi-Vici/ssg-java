package com.sh.polymorphism._03._interface;

public interface IProduct {
//    public static final int MAX_NUM = 100;

// 원래 상수는 위와 같이 작성해야 하지만 interface내에서는 이렇게만 써도 됨(상수만 되기 때문)
    int MAX_NUM = 100;
//    public abstract void printInfo();
    void printInfo();

    // 일반 메소드 작성할 수 없음
//    public void method(){}

    /**
     * 자식 객체에 물려줄 수 있는 일반 메소드 - default 메소드
     */
    public default void defaultMethod(){
        System.out.println("IProduct#defaultMethod 호출!");
    }

    /**
     * static 메소드는 객체 생성없이 사용 가능
     */
    public static void staticMethod(){
        System.out.println("IProduct.staticMethod 호출!");
    }
}
