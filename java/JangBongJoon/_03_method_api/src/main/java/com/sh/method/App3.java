package com.sh.method;

public class App3 {
    public static void main(String[] args) {
        String name;
        //매개변수 parameter
        //- 메서드 선언부에 작성된 변수
        //메서드 호출시 매개인자가 대입된다
        //메서드안에 선언된 변수와 동일하다
        //매개인자 argument
        //메서드 호출부에서 전달하는 값
        //메더드 호출시에 매개변수에 대입되어 사용된다.
        App3 app = new App3();
        app.printName("홍길동"); //매개인자 argument  변수를 사용해도 변수의 값이 매개인자로써 사용된다.
        //자바에서 선어분와 호출부의 매개변수 매개인자는 정확히 일치해야한다
        app.printUsernameAndAge("홍길동", 33);
        app.printUsernameAndAge("sinsa" , 45);

        byte bnum = 100;
        app.test(bnum);
        long lum = 1L;
        app.test((int )lum); //long -> int 자동형변환 되지않으므로 명시적으로 형변환 처리
        //연산식으로 작성하면 우선적으로 계산하고 결과를 전달한다.
        app.test(1 * 2 * 3 * 4 * 5); //app.test(120)이랑 동일하다
    }
    public void printName(String name ) { //매개변수  parameter
        System.out.println("이름은 " + name);
    }

    public void printUsernameAndAge(String name, int age) {
        System.out.println("------------------");
        System.out.println(name + age);
        System.out.println("------------------");
    }

    public void test(int n) {
        System.out.println(n);
    }
}
