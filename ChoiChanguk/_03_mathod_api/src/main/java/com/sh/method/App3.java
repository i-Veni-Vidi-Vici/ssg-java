package com.sh.method;

/**
 * <pre>
 * 매개변수 Parameter
 * - 메소드 선언부에 작성된 변수(공간)
 * - 매소드 호출시 매개인자가 대입된다.
 * - 메소드안에 선언된 변수와 동일하다.
 *
 * 매개인자 Argument
 * - 메소드 호출부에서 전달하는 값
 * - 메소드 호출시에 매개변수에 대입된다.
 *
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        App3 app3 = new App3();
        String id;
        int age;

        id = "honggd";
        age=33;
        app3.printNameAndAge(id,age);// 변수를 사용해도 매개인자이다

        id = "sinsa";
        age=45;
        app3.printNameAndAge(id,age);

        //자바에서 선언부와 호출부의 매개변수- 매개인자가 정확히 일치해야 한다.
        //홍길동 33, 신사임당 45
        //printNameAndAge 메소드 만들어서 출력


        //매개인자와 매개변수 타입은 일치 해아한다.
        byte bnum=100;
        app3.test(bnum);
        long lnum=1l;
        app3.test((int)lnum);
        //작은 개념 -> 큰 개념은 변환 가능, 큰 개념->작은 개념으로 변환 불가능
        //연산식을 작성하면, 우선적으로 계산하고, 전달
    }

    public void printNameAndAge(String id,int age) {
        System.out.println("id: "+id + " 나이 : "+age);
    }

    public void test(int n) {
        System.out.println(n);
    }
}
