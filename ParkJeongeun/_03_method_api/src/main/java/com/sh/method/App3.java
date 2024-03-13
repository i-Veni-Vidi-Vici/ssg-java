package com.sh.method;

/**
 * <pre>
 * 매개변수 (Parameter) : 공간
 * - 메소드 선언부에 작성된 변수(공간)
 * - 메소드 호출 시 매개인자가 대입됨
 * - 메소드 안에 선언된 변수와 동일
 *
 * 매개인자 (Argument) : 값
 * - 메소드 호출부에서 전달하는 값
 * - 메소드 호출 시 매개변수에 대입되어 사용됨
 * </pre>
 */

public class App3 {
    public static void main(String[] args) {
        App3 app = new App3();

//        app.printName ("홍길동"); // 아래 두줄로 나눠적어도 동일
        String name = "홍길동";
        app.printName(name); // 변수를 사용해도 변수의 값이 매개인자로써 사용됨

        name = "신사임당";
        app.printName(name); // 위에서 쓴 변수 또 써도 됨

        // 자바에서 선언부와 호출부의 매개변수-매개인자는 타입,개수가 정확히 일치해야 함
//        app.printName(); 매개인자 없음
//        app.printName(123); 타입 불일치
//        app.printName("홍", "길동"); 개수 불일치

        // honggd 33
        // sinsa 45
        // printUsernameAndAge 메소드를 선언하고 해당 데이터 출력
        String userName = "honggd";
        int age = 33;
        app.printUsernameAndAge(userName, age); //userName과 age 적는 순서도 지켜야함

        userName = "sinsa";
        age = 45;
        app.printUsernameAndAge(userName, age);

        // 매개인자와 매개변수의 타입은 일치해야함
        byte bnum = 100;
        app.test(bnum);
//        int n = bnum; // int = byte -> int = int
        long lnum = 1L;
//        app.test(lnum); // long -> int 자동형변환X
        app.test((int)lnum);
        // 연산식으로 작성하면, 우선적으로 계산하고 결과 전달
        app.test(1 * 2 * 3 * 4 * 5); // app.test(120)과 동일

    }

    public void test(int n) {
        System.out.println(n);
    }

    public void printName(String name) {
        System.out.println("이름은 " + name + "입니다.");

    }

    public void printUsernameAndAge(String userName, int age) {
        System.out.println("-----------------------");
        System.out.println("userName : " + userName);
        System.out.println("age : " + age);
        System.out.println("-----------------------");
    }

}