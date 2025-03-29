package com.sh.method;

/**
 * <pre>
 * 매개변수 Parameter
 * - 메소드 선언부에 작성된 변수(공간)
 * - 메소드 호출시 매개인자가 대입된다.
 * - 메소드안에 선언된 변수와 동일하다.
 *
 * 매개인자 Argument
 * - 메소드 호출부에서 전달하는 값
 * - 메소드 호출시에 매개변수에 대입되어 사용된다.
 *
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        App3 app = new App3();
        String name = "홍길동";
        app.printName(name); // 변수를 사용해도 변수의 값이 매개인자로써 사용된다.
        name = "신사임당";
        app.printName(name);

        // 자바에서 선언부와 호출부의 매개변수-매개인자는 타입과 개수가 정확히 일치해야 한다.
//        app.printName();
//        app.printName(123);
//        app.printName("홍", "길동");

        // honngd 33
        // sinsa 45
        // printUsernameAndAge 메소드를 선언하고, 해당 데이터를 출력
        String username = "honggd";
        int age = 33;
        app.printUsernameAndAge(username, age);
        username = "sinsa";
        age = 45;
        app.printUsernameAndAge(username, age);
//        app.printUsernameAndAge(age, username);

        // 매개인자와 매개변수의 타입은 일치해야 한다.
        byte bnum = 100;
        app.test(bnum);
//        int n = bnum; // int = byte -> int = int
        long lnum = 1L;
        app.test((int) lnum); // long -> int 자동형변환 되지 않으므로, 명시적으로 형변환 처리
        // 연산식으로 작성하면, 우선적으로 계산하고, 결과를 전달한다.
        app.test(1 * 2 * 3 * 4 * 5); // app.test(120)와 동일
    }

    public void test(int n){
        System.out.println(n);
    }

    public void printUsernameAndAge(String username, int age) {
        System.out.println("----------------------");
        System.out.println("username : " + username);
        System.out.println("age : " + age);
        System.out.println("----------------------");
    }

    public void printName(String name) {
        System.out.println("이름은 " + name + "입니다.");
    }
}

//출력 순서에 대한 공부
//main 메소드가 시작됩니다.
//name 변수에 "홍길동" 문자열을 할당합니다.
//printName 메소드를 호출하면서 name 변수를 매개인자로 전달합니다.
//printName 메소드 내부에서는 받은 매개인자를 출력합니다.
//name 변수의 값을 "신사임당"으로 변경합니다.
//다시 printName 메소드를 호출하면서 name 변수를 매개인자로 전달합니다.
// printName 메소드 내부에서는 받은 매개인자를 출력합니다.
//"honggd" 문자열을 username 변수에 할당하고, 33을 age 변수에 할당합니다.
//printUsernameAndAge 메소드를 호출하면서 username과 age 변수를 매개인자로 전달합니다.
// printUsernameAndAge 메소드 내부에서는 받은 매개인자를 출력합니다.
//"sinsa" 문자열을 username 변수에 할당하고, 45를 age 변수에 할당합니다.
//다시 printUsernameAndAge 메소드를 호출하면서 username과 age 변수를 매개인자로 전달합니다.
// printUsernameAndAge 메소드 내부에서는 받은 매개인자를 출력합니다.
//byte 타입 변수 bnum에 100을 할당합니다.
//test 메소드를 호출하면서 bnum 변수를 매개인자로 전달합니다. test 메소드 내부에서는 받은 매개인자를 출력합니다.
//long 타입 변수 lnum에 1L을 할당합니다.
//lnum 변수를 int 타입으로 형변환하여 test 메소드를 호출합니다. test 메소드 내부에서는 받은 매개인자를 출력합니다.
//1 * 2 * 3 * 4 * 5의 계산 결과를 매개인자로 전달하여 test 메소드를 호출합니다. test 메소드 내부에서는 받은 매개인자를 출력합니다.

//따라서 출력 순서는 다음과 같습니다:
//이름은 홍길동입니다.
//이름은 신사임당입니다.
//----------------------
//username : honggd
//age : 33
//----------------------
//----------------------
//username : sinsa
//age : 45
//----------------------
//100
//1
//120