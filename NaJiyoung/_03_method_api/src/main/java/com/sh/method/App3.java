package com.sh.method;

/**
 * <pre>
 * 매개변수 Parameter
 * - 메소드 선언부에 작성된 변수(공간)
 * - 메소드 호출시 매개인자가 대입된다.
 * - 메소드 안에 선언된 변수와 동일하다.
 *
 * 매개인자 Argument
 * - 메소드 호출부에서 전달하는 값
 * - 메소드 호출시에 매개변수에 대입되어 사용된다.
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        App3 app = new App3();
//        app.printName("홍길동");   // 메소드 호출
        String name = "홍길동";    // 여기 name은 인수(매개인자)
        app.printName(name);    // 변수를 사용해도 변수의 값이 매개인자로써 사용된다.
        name = "신사임당";
        app.printName(name);

        // 자바에서 선언부와 호출부의 매개변수-매개인자는 타입과 개수가 정확히 일치해야 한다.
//        app.printName();
//        app.printName(123);
//        app.printName("홍", "길동");

        // honggd 33
        // sinsa 45
        // printUsernameAndAge  메소드를 선언하고, 해당 데이터를 출력
        String username = "honggd";
        int age = 33;
        app.printUsernameAndAge(username, age);
        username = "sinsa";
        age = 45;
        app.printUsernameAndAge(username, age);
//        app.printUsernameAndAge(age, username);   순서 중요

        // 매개인자와 매개변수의 타입은 일치해야 한다.
        byte bnum = 100;
        app.test(bnum);
//        int n = bnum; // int = byte -> int = int
        long lnum = 1L; // L은 long타입
        app.test((int)lnum); // long -> int 자동형변환 되지 않으므로, 명시적으로 형변환 처리
        // 연산식으로 작성하면, 우선적으로 계산하고, 결과를 전달한다.
        app.test(1 * 2 * 3 * 4 * 5);    // app.test(120)와 동일
    }

    public void printName(String name) {    // 메소드 선언
        // String name = "홍길동";     파라미터에서 받아오기 때문에 변수 선언 안해도 된다.
        System.out.println("이름은 " + name + "입니다."); // 여기 name은 파라미터(매개변수)
    }

    public void printUsernameAndAge(String username, int age) {
        System.out.println("--------------------");
        System.out.println("username : " + username);
        System.out.println("age : " + age);
        System.out.println("--------------------");
    }

    public void test(int n) {
        System.out.println(n);
    }
}
