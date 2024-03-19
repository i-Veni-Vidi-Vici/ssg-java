package com.sh.method;

/**
 * <pre>
 * 매개변수 Parameter
 * - 메소드 선언부에 작성된 변수("공간")
 * - 메소드 호출시 매개인자가 대입된다.
 * - 메소드 안에 선언된 변수와 동일하다.
 *
 * 매개인자 Argument
 * - 메소드 호출부에서 전달하는 "값"
 * - 메소드 호출시에 매개변수에 대입되어 사용된다.
 *
 * </pre>
 */

public class App3 {
    public static void main(String[] args) {
        App3 app = new App3();
        String name = "홍길동";
        app.printName("홍길동"); // "홍길동" <= 매개인자, 변수가 대입되어도 매개인자의 자리!
        name = "신사임당";
        app.printName(name); // name <= 매개인자, 변수가 대입되어도 매개인자의 자리!

        // 자바는 엄격한 문법을 가졌다.
        // 자바에서 선언부와 호출부의 매개변수-매개인자는 정확히 일치해야 한다.
//        app.printName(); //Expected 1 arguments but found 0
//        app.printName(123); //Required type: String, Provided: int
//        app.printName("홍", "길동"); //Expected 1 arguments but found 2

        // hongd 33
        // sinsa 45
        // printNameAndAge 메소드를 선언하고, 해당 데이터를 출력
        app.printUsernameAndAge("honggd", 33);
        app.printUsernameAndAge("sinsa", 45);

        byte bnum = 100;
        long lnum = 1L;
        app.test(bnum); // byte -> int
        app.test((int)lnum); // long -> int (X) 자동형변환 되지 않으므로, 명시적으로 형변환 처리
        // 연산식으로 작성하면, 우선적으로 계산하고, 결과를 전달한다.
        app.test(1 * 2 * 3 * 4 * 5); // 120
    }

    public void printName(String name) { // String name <= 매개변수
        System.out.println("이름은 " + name + "입니다.");
    }

    public void printUsernameAndAge(String name, int age) { // 매개변수
        System.out.println("-------------------");
        System.out.println("username: " + name);
        System.out.println("age: " + age);
        System.out.println("-------------------");
    }

    public void test(int num) {
        System.out.println(num);
    }
}
