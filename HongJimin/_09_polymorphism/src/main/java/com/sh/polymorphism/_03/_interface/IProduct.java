package com.sh.polymorphism._03._interface;

public interface IProduct { //인터페이스는 일반 메소드 쓸 수 없음!
//    public static final int MAX_NUM = 100; // -> 인터페이스는 일반 메소드 쓸 수 없음!
    int MAX_NUM = 100; //위처럼 안써도 public static final이 있는 것처럼 적용됨

//    public abstract void printInfo(); // -> 인터페이스는 일반 메소드 쓸 수 없음!
    void printInfo(); //위처럼 안써도 public static final이 있는 것처럼 적용됨

    /**
     * 자식 객체에 물려줄 수 있는 일반 메소드 - defult메소드
     */

    public default void defultMethod() { //IProduct를 구현한 클래스들이 사용할 수 있음
        System.out.println("IProduct#defultMehtod호출!!");
    }

    /**
     * static 메소드는 객체 생성 없이 사용가능
     */
    public static void staticMethod() {
        System.out.println("IProduct.staticMethod 호출!");
    }

}
