package com.sh.singletone;

/**
 * <pre>
 * 싱글턴패턴
 * - 생성 디자인패턴 중에 하나.
 * - 객체를 프로그램 운영중에 하나만 생성해서 공유하는 방식
 * </pre>
 */
public class App {
    public static void main(String[] args) {
//      Manager manager = new Manager(); // private 생성자이기 때문에 외부에서 객체 생성이 안됨
        Manager manager = Manager.getInstance();
        System.out.println(manager);
        manager.getValues()[0] = "helloworld";


        Manager manager2 = Manager.getInstance();
        System.out.println(manager2);
        System.out.println(manager2.getValues()[0]);
    }
}
