package com.sh.method;

/**
 * <pre>
 * 매개변수 Parameter
 * - 메소드 선언부에 작성된 변수 (공간)
 * - 메소드 호출 시 매개인자가 대입된다.
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
        app.printName(name); // name -> 매개인자 // 변수를 사용해도 변수의 값이 매개인자로써 사용된다.
        name = "신사임당";
        app.printName(name);

        // 자바에서 선언부와 호출부의 매개변수-매개인자는 타입과 갯수가 정확히 일치해야 한다. (선언한대로 사용하자)
//        app.printName();
//        app.printName(123);
//        app.printName("홍" , "길동")

        // 홍길동 33
        // 신사임당 45
        // printUsernameAndAge 메소드를 선언하고, 해당 데이터를 출력
        String username = "홍길동";
        int age = 33;
        app.printUsernameAndAge(username , age);

        username = "신사임당";
        age = 45;
        app.printUsernameAndAge(username , age);

        // 매개인자
        byte bnum = 100;
        app.test(bnum); // int n = bnum; // int = byte -> int = int
        long lnum = 1L;
        app.test((int)lnum); // long -> int 반대방향이여서 자동 형변환이 되지 않으므로, 명시적으로 형변환 처리 필요
        // 연산식을 작성하면 우선적으로 계산하고 결과를 전달한다.
        app.test(1 * 2 * 3 * 4 * 5); // app.test(120); 과 동일
    }

    // 선언
    public void test(int n){
        System.out.println(n);
    }
    public void printName(String name) { // String name -> 매개변수
        System.out.println("이름은 " + name + "입니다.");
    }

    public void printUsernameAndAge(String username , int age) {
        System.out.println("--------------------------");
        System.out.println("username : " + username);
        System.out.println("age : " + age);
    }



}
