package com.sh.method;

/**
 * <pre>
 *     리턴 return
 *     호출된 메소드의 실행코드가 실행이 완료되면, 호출부로 돌아간다
 *     모든 호출된 메소드는 리턴한다
 *
 *     리턴값
 *     - 리턴시에 값을 전달할 수 있다.
 *     - 메소드 선언부에 지정한 타입과 일치하는 값을 작성해야 한다.
 *
 * </pre>
 */


public class App5 {
    public static void main(String[] args){
        App5 app = new App5();
        app.a();
        System.out.println("main");
        return; //프로그램 종료를 의미한다

    }

    public void a(){
        b();
        System.out.println("a");
    }

    public void b(){
        System.out.println("b");
    }
}
