package com.sh.singletone;

/**
 * 싱글턴패턴
 * - 생성 디자인 패턴 중에 하나.
 * - 객체를 프로그램 운영중에 하나만 생성해서 공유하는 방식
 */
public class App {
    public static void main(String[] args) {
        // Manager manager = new Manager(); // private 생성자이므로 외부에서 객체 생성을 방지
        Manager manager1 = Manager.getInstance();
        System.out.println(manager1);
        manager1.getValues()[0] = "hello world";

        Manager manager2 = Manager.getInstance();
        System.out.println(manager2);
        System.out.println(manager2.getValues()[0]);
    }
}
