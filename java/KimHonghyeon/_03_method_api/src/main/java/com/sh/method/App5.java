package com.sh.method;

/**
 * 리턴(return)
 * -호출된 메소드의 실행이 종료되면 호출 지점으로 돌아간다.
 * -모든 호출된 메소드는 돌아간다.
 * -모든 메소드의 마지막 줄에는 return이 작성되어야 하고 생략해도 컴파일러가 자동 추가.
 *
 * 리턴값
 * -리턴시에 값을 전달할 수 있다.
 * -메소드 선언부에 지정한 타입과 일치하는 값을 작성해야 한다.
 */

public class App5 {
    public static void main(String[] args) {
        App5 app = new App5();
        app.a();
        System.out.println("main");
    }

    public void a(){
        System.out.println("a");
        b();
        return; // void 반환타입인 모든 메소드에서 return 구문이 생략되어 있음.
    }

    public void b(){
        System.out.println("b");
    }
}
