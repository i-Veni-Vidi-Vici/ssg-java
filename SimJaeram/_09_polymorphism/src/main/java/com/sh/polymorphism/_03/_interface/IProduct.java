package com.sh.polymorphism._03._interface;

/**
 * <pre>
 *     컴파일하면 클래스 파일이 만들어진다.
 *     build>classes
 * </pre>
 */

public interface IProduct {
//    public static final int MAX_NUM = 100;
    int MAX_NUM = 100;
//    public abstract void printInfo();
    void printInfo();

    // 일반 메소드를 작성할 수 없다.
//    public void method() {}
    /**
     * <pre>
     *     자식 객체에 물려 줄 수 있는 일반메소드 - default메소더
     * </pre>
     */
    public default void defaultMethod() {
        System.out.println("IProduct#ddefaultMethod 호출!!!");
    }

    /**
     *
     * <pre>
     *     static 메소드는 객체생성없이 사용가능
     * </pre>
     */
    public static void staticMethod() {
//        System.out.println("")
    }
}

