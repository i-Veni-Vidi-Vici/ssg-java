package com.sh.singletone;

public class App {
    public static void main(String[] args) {
        //Manager manager = new Manager();
        //private 생성자라 직접 객체 생성 불가

        Manager manager1 = Manager.getInstance();
        System.out.println(manager1.hashCode());
        Manager manager2 = Manager.getInstance();
        System.out.println(manager2.hashCode());
    }
}
