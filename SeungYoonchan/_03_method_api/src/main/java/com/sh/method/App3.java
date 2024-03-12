package com.sh.method;

/**
 * <h3>매개 변수 Parameter</h3>
 * <pre>
 *     - 메소드 선언부에 선언한 변수
 *     - 메소드 호출시 매개인자가 대입된다.
 *     - 메소드 안에 선언된 변수와 동일
 * </pre>
 * <h3>매개 인자 Argument</h3>
 * <pre>
 *     - 메소드 호출부에서 전달하는 값
 *     - 메소드 호출시에 매개변수에 대입되어 사용된다.
 * </pre>
 */
public class App3 {
    public static void main(String[] args){
        App3 app = new App3();
        String name = "홍길동";
        app.printName(name); // 변수를 사용해도 변수의 값이 매개인자로써 사용된다.

        name = "신사임당";
        app.printName(name);

        // 자바에서 선언부와 호출부의 매개변수 - 매개인자는 타입과 개수가 정확히 일치해야한다.
//        app.printName();          // 매개인자 없음
//        app.printName(123);       // 타입이 다름
//        app.printName("홍","길동");// 개수가 다름

        // honngd 33
        // sinsa 45
        // printUsernameAndAge 메소드 선언, 데이터 출력
        app.printUsernameAndAge("honngd",33);
        app.printUsernameAndAge("sinsa",45);

        byte bnum = 100;
        app.test(bnum);
//        int n = bnum; // int = byte -> int = int
        long lnum = 1L;
        app.test((int)lnum);// long -> int 자동 형변환 되지 않으므로, 명시적으로 형변환 처리

        app.test(1*2*3*4*5); // 연산 후에 전달 ( app.test(120)과 동일 )
    }

    public void test(int n){
        System.out.println(n);
    }
    public void printUsernameAndAge(String id, int age){
        System.out.println("Id : " + id + " Age : " + age);
    }

    public void printName(String name){
        System.out.println("이름은 " + name + " 입니다.");
    }
}
