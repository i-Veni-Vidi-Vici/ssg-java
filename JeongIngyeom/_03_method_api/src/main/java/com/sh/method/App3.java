package com.sh.method;

/**
 * <pre>
 * 매개변수 Parameter
 * - 메소드 선언부에 작성된 변수(공간)
 * - 메소드 호출시
 *
 * 매개인자 Argument
 * - 메소드 호출부에서 전달하는 값
 * - 메소드 호출시에 매개변수에 대입되어 사용된다.
 *
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        App3 app3 = new App3();
        String name = "홍길동";
        app3.printName(name);       // 변수를 사용해도 변수의 값이 매개인자로써 사용된다.
        name = "신사임당";
        app3.printName(name);

        // 자바에서 선언부와 호출부의 매개변수-매개인자는 정확히 일치해야 한다.
        //app3.printName();     매개변수와 매개인자의 개수가 일치하지 않음.
        //app3.printName(123);  타입이 일치하지 않음.

        // 홍길동 33
        // 신사임당 45
        // printUsernameAndAge 메소드를 선언하고, 해당 데이터를 출력
        app3.printUsernameAndAge("홍길동", 33);
        app3.printUsernameAndAge("신사임당", 45);

        // 매개인자와 매개변수의 타입은 일치해야 한다.
        byte bnum = 100;
        app3.test(bnum);        // int n = bnum; 한 것과 동일 -> int = byte가 int = int로 변환됨

        long lnum = 1L;
        app3.test((int) lnum);      // int n = lnum; 한 것과 동일 -> long은 int로 자동형변환 되지 않으므로, 명시적으로 형변환 처리

        // 연산식으로 작성하면, 우선적으로 계산하고, 결과를 전달한다.
        app3.test(1 * 2 * 3 * 4 * 5);   // app3.test(120)과 동일
    }

    public void printName(String name) {
        System.out.println("이름은 " + name + "입니다.");
    }

    public void printUsernameAndAge(String userName, int age){
        System.out.println("유저 이름 : " + userName + "\n유저 나이 : " + age);
    }

    public void test(int n) {
        System.out.println(n);
    }
}
