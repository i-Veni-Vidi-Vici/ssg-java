package com.sh.method;

/**
 * <pre>
 *     매개변수 parameter
 *     - 메소드 선언부에 작성한 변수(공간)
 *     - 메소드 호출시 매개인자가 대입된다.
 *     - 메소드 안에 선언된 변수와 동일하다.
 *
 *     매개인자 argument
 *     - 메소드 호출부에 전달하는 값
 *     - 메소드 호출시에 매개변수에 대입되어 사용된다.
 * </pre>
 */

public class App3 {
    public static void main(String[] args) {
        App3 app = new App3();
        String name = "홍길동";
        app.printName(name); // 매개인자, 리터럴이 아닌 변수를 사용해도 매개인자로써 사용된다.
        name = "신사임당";
        app.printName(name);
        System.out.println();

        // 자바에서 메소드 선언부와 호출부의 매개변수-매개인자는 타입과 개수가 정확히 일치해야 한다.
//        app.printName();
//        app.printName(123);   // String인데, int 입력
//        app.printName("홍", "길동"); // 개수가 1개인데, 2개 입력

        // honngd 33
        // sinsa 45
        // printUsernameAndAge 메소드를 선언하고, 해당 데이터를 출력
        app.printUsernameAndAge("honngd", 33);
        app.printUsernameAndAge("sinsa", 45);
//        app.printUsernameAndAge(45, sinsa);

        // 매개변수와 매개인자의 타입은 일치해야 한다.
        byte bnum = 100;
        app.test(bnum);
//        int n = bnum; // int = byte -> int = int
        long lnum = 1L;
        app.test((int) lnum);       // long -> int 자동형변환 되지 않으므로, 명시적으로 형변환 처리
        // 연산식으로 작성하면, 우선적으로 계산하고, 결과를 전달한다.
        app.test(1*2*3*4*5);    // app.test(120)과 동일
    }

    public void test(int n) {
        System.out.println(n);
    }
    public void printName(String name) { // 매개변수
        System.out.println("이름은 " + name + "입니다.");
    }

    public void printUsernameAndAge(String userName, int age) {
        System.out.println("유저 네임은 " + userName + ", 나이는 " + age + " 입니다.");
    }
}
