package com.sh.polymorphism_03._interface;

/**
 * Interface 인터페이스
 * 자바 클래스와 유사한 현태지만, 상수와 추상 메소드만 가질 수 있다
 * jdk8부터는 default/static메소드도 사용 할 수 있다.
 * implements 키워드를 사용한다.
 * - 상속은 단일 상속이지만, 구현은 다중 구현이 가능하다. implements IProduct, Discountable
 * 인터페이스끼리의 상속은 extends 키워드를 사용한다. 자식 인터페이스 extends 부모 인터페이스 1, 부모인터페이스 2
 */
public interface IProduct {

    static int MAX_VALUE = 10;

    public void getInfo();

    //일반 메소드를 작성할 수 없다
    //public void methd(){}
    /**
     * 자식 객체에 물려줄 수 있는 일반 메소드 - default 메소드
     */
    public default void defaultMethod(){
        System.out.println("IProduct#defaultMethod 호출 ");
    }

    /**
     * static 메소드는 객체 생성없이 사용가능
     */
    public static void staticMethod(){
        System.out.println("Iproduct.staticMehtod 호출 ");
    }
}
