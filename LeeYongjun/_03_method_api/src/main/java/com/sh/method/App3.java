package com.sh.method;

/**
 * <pre>
 * 매개변수 Parameter
 * - 메소드 선언부에 작성된 변수(공간) **변수 - 값하나를 쓰기 위한 메모리상의 공간
 * - 메소드 호출 시 매개인자가 대입된다.
 * - 메소드 안에 선언된 변수와 동일하다.
 *
 * 매개인자 Argument
 * - 매소드 호출부에서 전달하는 값
 * - 메소드 호출시에 매개변수에 대입되어 사용된다.
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        App3 app = new App3();

        String name = "hong";
        int age = 33;
        app.printNameAndAge(name,age); // 변수를 사용해도 변수의 값이 매개인자로써 사용된다.
        name = "shin";
        age = 45;
        app.printNameAndAge(name,age);

        // 자바에서 선언부와 호출부의 매개변수-매개인자는 타입과 개수가 정확히 일치해야 한다.
        // app.printName();
        // app.printName(123);
        // app.printName("홍", "길동");

        // hong 33
        // shin 45
        // printNameAndAge 메소드를 선언하고, 해당 데이터를

        //매개인자와 매개변수의 타입은 일치해야 한다.
        byte bnum = 100;
        app.test(bnum);
        // int n = bnum; // int = byte -> int = int
        long lnum = 1L;
        app.test((int) lnum); // long -> int 자동형변환 되지 않으므로, 명시적으로 형변환 처리를 해야한다.
        // 연산식으로 작성하면, 우선적으로 계산하고, 결과를 전달한다.
        app.test(1 * 2 * 3 * 4 * 5); // app.test(120)과 동일
    }

    public void printNameAndAge(String name ,int age) {
        System.out.println("이름은 "+ name + " 이고 " + "나이는 " + age +"입니다." );
    }
    // 매개인자
    public void test(int n){
        System.out.println(n);
    }
}
