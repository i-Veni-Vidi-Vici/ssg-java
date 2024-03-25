package com.sh.singletone;

/**
 * <pre>
 *     싱글턴패턴
 *     - 생성 디자인 패턴 중 하나
 *     - 객체를 프로그램 운영중에 하나만 생성해서 공유하는 방식
 *
 * </pre>
 */
public class App {
    public static void main(String[] args) {

        Manager manager = Manager.getInstance();
        System.out.println(manager);

        manager.getValues()[0] = "helloworld";
        String str = manager.getStr();
        manager.getInts()[0] = 10;
        System.out.println(manager.getInts()[0]);
//        manager.getNum()=100;



        Manager manager2 = Manager.getInstance();
        System.out.println(manager2);
        System.out.println(manager2.getValues()[0]);

    }
}
