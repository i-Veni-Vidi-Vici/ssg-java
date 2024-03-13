package com.sh.method;

/*
리턴
-호출된 메소드의 실행이 완료되면 호출부로 돌아가는 것을 의미한다
-모든 호출된 메소드는 리턴한다
-모든 메서드 마지막 줄에는 rerturn이 작성되어야 하고 이를 생략해도 comiler가 자동으로 추가한다.

리턴값
-리턴시에 값을 전달할 수 있다.
-명시적으로 값을 작성해야한다.
메서드 선언부에 지정한 타입과 일치하는 값을 작성해야 한다.
 */

public class App5 {
    public static void main(String[] args) {
        App5 app = new App5();
        app.a();
        System.out.println("main");


    }
    public void a() {
        b();
        System.out.println("a");
        //모든 메서드 마지막에는 return 구문이 생략되어있다.

    }

    public void b() {
        System.out.println("b");
    }
}

