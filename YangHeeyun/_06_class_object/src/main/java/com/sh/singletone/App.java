package com.sh.singletone;

/**
 * <pre>
 * 싱글턴패턴
 * - 생성 디자인패턴 중에 하나.
 * - non-static이면서 공유목적으로 사용할 수 있는 방식
 * - 객체를 프로그램 운영중에 하나만 생성해서 공유하는 방식.
 * </pre>
 */
public class App {
    public static void main(String[] args) {
//        Manager manager = new Manager(); //private 생성자이므로 외부에서 객체 생성을 방지
        Manager manager = Manager.getInstance();
        System.out.println(manager);
        manager.getValues()[0] = "Helloworld";

        Manager manager2 = Manager.getInstance();
        System.out.println(manager2);
        System.out.println(manager2.getValues()[0]);

    }
}
