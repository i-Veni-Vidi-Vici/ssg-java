package com.sh.method;

/**
 * <pre>
 * 리턴
 * - 호출된 메소드의 실행이 완료되면 호출부로 돌아가는 것을 의미
 * - 모든 호출된 메소드는 리턴함
 * - 모든 메소드 마지막 줄에는 return이 작성되어야 하고, 이를 생략해도 compiler가 자동으로 추가함
 *
 * 리턴값
 * - 리턴시에 값을 전달할 수 있음
 * - 메소드 선언부에 지정한 타입과 일치하는 값을 작성해야 함
 * </pre>
 */

public class App5 {
    public static void main(String[] args) {
        App5 app = new App5();
        app.a();
        System.out.println("main");
        return; // main에서는 프로그램 종료 의미
    }

    public void a() {
        b();
        System.out.println("a");
        return; // 모든 메소드 마지막에는 return 구문이 생략되어 있음

    }

    public void b() {
        System.out.println("b");
        return;
    }
}
