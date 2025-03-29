package com.sh.method;


/**
 *
 */
public class App3 {
    public static void main(String[] args) {
        App3 app = new App3();
        String name = "홍길동";
        app.printName("name");// 변수를 사용해도 변수의 값이 매개 인자로써 사용된다.
        name = "신사임당";
        app.printName(name);

        //자바에서 선언부와 호출부의 매개변수  - 매개 인자는 타입과 개수가 정확히 일치해야 함!
//        app.printName();
//        app.printName(123);

        //honggd 33
        //sinsa 45
        //printUsernameAndAge 메소드를 선언하고, 해당 데이터를 출력
        app.printUsernameAndAge("honggd", 33);
        app.printUsernameAndAge("sinsa", 45);

        //매개 인자와 매개 변수의 타입은 일치해야 한다.
        byte bnum = 100;
        app.test(bnum);
//        int n = bnum; //int = byte -> int = int
        long lnum =1L;
        app.test((int)lnum); // long -> int 자동 형변환 되지 않으므로, 명시적으로 형변환 처리해야 함

        //연산식으로 작성하면, 우선적으로 계산하고 결과를 전달한다.
        app.test(1*2*3*4*5); //120으로 출력됨, app.test(120)과 동일함
    }

    public void test(int n) {
        System.out.println(n);
    }

    public void printName(String name) {
        System.out.println("이름은 " + name + "입니다.");
    }

    public void printUsernameAndAge(String id, int age) {
        System.out.println(id + "은 " + age + "살 입니다.");
    }
}
