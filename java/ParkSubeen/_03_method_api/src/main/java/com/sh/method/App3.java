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
        String name = "홍길동"; // 한 블록 안에서만 같은 이름으로 생성되면 되기 때문에 name을 또 선언할 수 있는 것.
        app.printName(name); // 변수를 사용해도 변수의 값이 매개인자로써 사용된다.
        name = "신사임당";
        app.printName(name);
//        app.printName("홍길동"); // 홍길동은 매개인자

        // 자바에서 선언부와 호출부의 매개변수-매개인자는 타입과 개수가 정확히 일치해야 한다.
//        app.printName();
//        app.printName(123);
//        app.printName("홍", "길동");

        // honngd 33
        // sinsa 45
        // printUsernameAndAge 메소드를 선언하고, 해당 데이터를 출력
        app.printUsernameAndAge("honngd", 33);
        app.printUsernameAndAge("sinsa", 45);

        // 강사님 코드
//        String username = "honggd";
//        int age = 33;
//        app.printUsernameAndAge(username, age);
//        username = "sinsa";
//        age = 45;
//        app.printUsernameAndAge(username, age);
//        app.printUsernameAndAge(age, username); // 순서 조심해야함 (error)

        // 매개인자와 매개변수의 타입은 일치해야 한다.
        byte bnum = 100;
        app.test(bnum);
//        int n = bnum; // int = byte -> int = int
        long lnum = 1L;
        app.test((int) lnum); // long -> int 자동형변환 되지 않으므로, 명시적으로 형변환 처리
        // 연산식으로 작성하면, 우선적으로 계산하고, 결과를 전달한다.
        app.test(1 * 2 * 3 * 4 * 5); // app.test(120)와 동일
    }

    public void test(int n) {
        System.out.println(n);
    }

    public void printName(String name) { // name은 매개변수
        System.out.println("이름은 " + name + "입니다.");
    }

    public void printUsernameAndAge(String username, Integer age) {
        System.out.println("Username : " + username + ", " + "Age : " + age);

        // 강사님 코드
//        System.out.println("----------------------");
//        System.out.println("username : " + username);
//        System.out.println("age : " + age);
//        System.out.println("----------------------");
    }
}
