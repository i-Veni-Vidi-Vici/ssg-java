package com.sh.method;

/**
 * <pre>
 * 리턴
 * - 호출된 메소드의 실행이 완료되면, 호출부로 돌아가는 것을 의미한다.
 * - 모든 호출된 메서드는 리턴합니다.
 * - 모든 메소드 마지막 줄에는 return이 작성되어야 한다.
 * - 이를 생략해도 compile가 알아서 써준다
 *
 * 리턴값
 * - 리턴시에 값을 전달할 수 있다.
 * - 메소드 선언부에 지정한 타입과 일치하는 값을 작성해야 한다.
 * </pre>
 */
public class App5 {
    public static void main(String[] args) {
        App5 app5 =new App5();
        app5.a();
        System.out.println("main");

    }

    public void a() {
        b();
        System.out.println("a");
        return;// 모든 메소드 마지막에는 return 구문이 생략되어 있다.
    }

    public void b() {
        System.out.println("b");
        return;// 모든 메소드 마지막에는 return 구문이 생략되어 있다.
    }
}
