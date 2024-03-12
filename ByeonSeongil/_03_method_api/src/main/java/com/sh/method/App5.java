package com.sh.method;

/**
 * <pre>
 * 리턴
 * - 호출된 메서드의 실행이 완료되면, 호출부로 돌아가는 것을 의미한다,
 * - 모든 호출된 메서드는 리턴한다.
 * - 모든 메서드 마지막 줄에는 return이 작성되어야 하고, 이를 생략해도 compiler가 자동으로 추가한다.
 * </pre>
 */
public class App5 {
    public static void main(String[] args) {
        App5 app = new App5();
        app.a();
        System.out.println("main");

        return; // 프로그램 종료를 의미한다.
    }

    public void a() {
        b();
        System.out.println("a");
        return; //모든 메서드 마지막에는 return 구문이 생략되어 있다.
    }

    public void b() {
        System.out.println("b");
        return;
    }
}
