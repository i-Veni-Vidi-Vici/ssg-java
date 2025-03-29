package com.sh.method;


/**
 * ###리턴
 *
 * - 호출된 메소드의 실행이 완료되면, 호출부로 돌아가는 것을 의미함
 * - 모든 호출된 메소드는 리턴한다.
 * - 모든 메소드 마지막 줄에는 return이 작성되어야 하고, 이를 생략해도 compiler가 자동으로 추가해줌
 *
 * ### 리턴 값
 *
 * - 리턴 시에 값을 전달할 수 있음
 * - 메소드 선언부에 지정한 타입과 일치하는 값을 작성해야 함
 */
public class App5 {
    public static void main(String[] args) {
        App5 app = new App5();
        app.a();
        System.out.println("main");
        return; // 모든 메소드 마지막에는 return 구문이 생략되어 있다.

    }

    public void a() {
        System.out.println("a");
        b();
        return; // 모든 메소드 마지막에는 return 구문이 생략되어 있다.
    }

    public void b() {
        System.out.println("b");
        return; // 모든 메소드 마지막에는 return 구문이 생략되어 있다.

    }
}
