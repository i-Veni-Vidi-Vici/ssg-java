package com.sh.singletone;

/**
 * <pre>
 * 싱글턴패턴
 * - 생성 디자인 패턴 중 하나
 * - 객체를 프로그램 운영 중에 하나만 생성해서 공유하는 방식
 * </pre>
 */
public class App {
    public static void main(String[] args) {
//        Manager manager = new Manager(); // private 생성자이므로 외부에서 객체 생성 안됨
        Manager manager = Manager.getInstance();
        System.out.println(manager); //com.sh.singletone.Manager@7a81197d
        manager.getValues()[0] = "helloworld";

        Manager manager2 = Manager.getInstance();
        System.out.println(manager2); // com.sh.singletone.Manager@7a81197d (위에 manager와 같은 객체)
        // 위에 manager에서 값 넣고 manager2에서 출력도 가능
        System.out.println(manager2.getValues()[0]); // "helloworld"
    }
}
