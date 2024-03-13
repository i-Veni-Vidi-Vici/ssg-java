package com.sh.method;

/**
 * <pre>
 * 매개변수 Parameter - ! 공간 !
 * - 메소드 선언부에 작성된 변수 (값 하나를 가지기 위한 메모리상의 공간)
 * - 메소드 호출시 매개인자가 대입된다.
 * - 메소드안에 선언된 변수와 돌일하다.
 *
 * 매개인자 Argument - ! 값 !
 * - 메소드 호출부에 전달하는 값
 * - 메소드 호출시에 매개변수에 대입되어 호출시 사용된다.
 *
 * </pre>
 *
 */


public class App3 {
    public static void main(String[] args) {
        App3 app = new App3();
//        String name = "홍길동";
//        app.printName(name); // 호출 // 변수를 사용해도 변수의 값이 매개인자로써 사용된다.
//        // "홍길동" 매개인자
//        name = "신사임당";
//        app.printName(name);

        // 자바에서 선언부와 호출부의 매개변수-매개인자는 타입과 개수가 정확히 일치해야 한다.
//        app.printName();
//        app.printName(123); // 타입 불일치
//        app.printName("홍","길동"); // 개수 불일치

        // honggd 33
        // sinsa 45
        // printUsernameAndAge 메소드를 선언하고, 해당 데이터를 출력
        String id = "hongd";
        int age = 33;
        app.printUsernameAndAge(id,age);
        id = "sinsa";
        age = 45;
        app.printUsernameAndAge(id,age);

        //매개인자와 매개변수의 타입은 일치해야 한다.
        byte bnum = 100;
        app.test(bnum);
        // int n = bnum; // int = byte -> int = int
        long lnum = 1L;
        app.test((int) lnum); // long -> int 큰거에서 작은거라 자동형변환 되지 않으므로, 명시적을 형변환 처리
//      연산식으로 작성하면, 우선적으로 계산하고, 결과를 전달한다.
        app.test(1 * 2 * 3 * 4 * 5); // app.test(120) 과 동일



    }

    public void test(int n){
        System.out.println(n);
    }

    public void printUsernameAndAge(String id,int age) {
        System.out.println("-------------------------");
        System.out.println("id는 " + id +" 나이는 "+ age + " 입니다" );

    }

    //선언할 때 공간 만들어짐
    public void printName(String name) {
        // 이름을 주면 출력하라
        // 메소드에 매개변수 선언

        System.out.println("-------------------------");
        System.out.println("이름은 " + name + " 입니다.");
        System.out.println("-------------------------");

    }


}
