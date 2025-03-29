package com.sh.method;

/**
 * 매개변수 Parameter
 * - 메소드 선언부에 선언한 변수
 * - 메소드 호출시 매개인자가 대입된다.
 * - 메소드안에 선언된 변수와 동일하다
 *
 * 매개인자 Argument
 * - 메소드 호출부에서 전달하는 값
 * - 메소드 호출시에 매개변수에 대입되어 사용된다
 * -
 */


public class App3 {
    public static void main(String[] args) {
        App3 app = new App3();
        String name = "홍길동";
        app.printName(name);    //변수를 사용해도 변수의 값을 매개인자로서 사용
        name = "신사임당";
        app.printName(name);

        //자바에서 선언부와 호출부의 매개변수-매개인자는 정확히 일치해야한다
        //printUsernameAndAge 메소드 선언하고 해당 데이터를 출력
        //honngd 33
        //sinsa45
        app.printUsernameAndAge("honngd", 33);
        app.printUsernameAndAge("sinsa", 45);

        // 매개인자와 매개변수의 타입은 동일해야 한다.
        byte bnum = 100;
        //app.test(1_000_000_000_000);
        long lnum = 1L;
        app.test((int)lnum); //long -> int 자동형변환 되지 않으므로, 명식적으로 형변환 처리
        //연산식으로 작성하면, 우선적으로 계산하고 결과를 전달한다.
        app.test(1*2*3*4*5); //app.test(120) 와 동일



    }

    public void test(int n){
        System.out.println(n);
    }

    public void printName(String name){
        System.out.println("이름은 " + name + "입니다");
    }

    public void printUsernameAndAge(String name, int age){
        System.out.println(name + " " + age);

    }
}
