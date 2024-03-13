package com.sh.method;

/**
 * <pre>
 * 매개변수 Parameter
 * - 메소드 선언부에 선언한 변수(공간)
 * - 메소드 호출시 매개인자가 대입된다.
 * - 메소드안에 선언된 변수와 동일하다.
 * 매개인자 Argument
 * - 메소드 호출부에서 전달하는 값
 * - 메소드 호출시에 매개변수에 대입되어 사용된다.
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        App3 app = new App3();
        app.printName("홍길동");
        // 자바에서 선언부와 호출부의 매개변수-매개인자는 타입과 개수가 정확히 일치해야 한다.
        // app.printName();
        // app.printName(123);
        // app.printName("홍", "길동");

        // honngd 33
        // sinsa 45
        // printNameAndAge 메소드를 선언하고, 해당 데이터를 출력
        app.printIdAndAge("honngd", 33);
        app.printIdAndAge("sinsa", 45);

        // 매개인자와 매개변수의 타입은 일치해야한다.
        byte bnum = 100;
        app.test(bnum); // int = byte ==> int  = int
        long lnum = 1L;
        app.test((int)lnum); // int = long ==> error // 자동형변환 되지 않으므로, 명시적으로 형변환 처리
        // 연산식으로 작성하면, 우선적으로 계산하고, 결과를 전달한다.
        app.test(2 * 3 * 4); // app.test(24)와 동일
    }

    public void printName(String name) {
        System.out.println(name);
    }

    public void printIdAndAge(String id, int age) {
        System.out.println(id + ' ' + age);
    }

    public void test(int n) {
        System.out.println(n);
    }
}
