package com.sh.method;

/**
 * <pre>
 *  매개변수 Parameter
 *  - 메소드 선언부에 작성된 변수 (공간)
 *  - 메소드 호출시 매개인자가 대입된다
 *  - 메소드안에 선언된 변수와 동일하다.
 *
 *  매개인자 Argument
 *  - 메소드 호출부에서 전달하는 값
 *  - 메소드 호출시에 매개변수에 대입되어 호출시 사용된다.
 * </pre>
 */

public class App3 {

    public static void main(String[] args) {
        App3 app = new App3();
        app.printName("홍길동 "); //변수를 사용해도 변수의 값이 매기인자로써 사용된다.

        //자바에서 선언부와 호출부의 매개변수 - 매개인자는 타입과, 개수가 정확히 일치해야 한다.
        // app.printName(); - 매개인자가 없어서 오류
        // app.printName(123) - 매개인자의 타입이 일치하지 않아서 오류가 발생됨.
        String name ;
        int age;
        name = "honngd";
        age = 33;
        app.printUsernameAndAge(name,age);
        name = "sinsa";
        age = 45;
        app.printUsernameAndAge(name,age);

        //매개 인자
        byte bnum = 100;
        //app.test(bunm);
        // int n  bnum; //int = byte -> int = int
        long lnum = 1L;
        app.test((int)lnum); // 자동형변환이 되지 않으므로, 명시적으로 형변환 처리
        //연산식으로 작성하면, 우선적으로 계산하고, 결과를 전달한다.
        app.test(1* 2*3*4*5); //우선적으로 계산하고 값이 데이털 전달  app.test(120)과 동일

    }

    public void printName(String name)
    {
        System.out.println("이름은 " + name + "입니다. ");
    }

    public void printUsernameAndAge(String name, int age)
    {
        System.out.println("이름  = " + name + " 나이 = " + age);
    }

    public void test(int n)
    {
        System.out.println(n);
    }

}
