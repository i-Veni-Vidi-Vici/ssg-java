package com.sh.method;

/**
 * <pre>
 *
 * </pre>
 */
public class App5 {
    public static void main(String[] args) {
        App5 app = new App5();
        app.a();
        System.out.println("main");
    }
    public void a() {
        System.out.println("a");
        b();
        return; // 모든 메소드 마지막에는 return 구문이 생략되어 있다.
    }
    public  void b() {
        System.out.println("b");
    }
}
