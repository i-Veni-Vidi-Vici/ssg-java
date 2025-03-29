package com.ssg.oop.field;

public class Test {
    int a = 100;
    static int s = 99;

    public static void main(String[] args) {
        Test t = new Test();
        t.test1();
        // 1000 (정답 : 100)
        // 999 (정답 : 99)

        t.test2();
        // 1000 (정답 : 100)

        Test t3 = new Test();
        t.test3(t3); // 200 (정답 : 10) //  test3메소드의 sout(t.a) 출력
        System.out.println(t3.a); // (정답 10)

        t.test4(t);
        // 1000
    }

    public void test1() {
        int a = 1000; // 왜 값변경이 안되지 -> int로 새로 선언해서 지역변수가 됨
        int s = 999; // 왜 값변경이 안되지 -> int로 새로 선언해서 지역변수가 됨
        System.out.println(this.a); // this 이용해서 필드 a 출력
        System.out.println(Test.s); // 필드 s는 static이므로 클래스명.s로 사용
    }

    public void test2() {
        Test t = new Test();
        // 1000이 출력되게 하려면
        // 1. 새로 생성한 t 객체로 호출 안하고 a = 1000만 작성
        // 2. sout(t.a)
        t.a = 1000;
        System.out.println(a);
    }

    public void test3(Test t) {
        t.a = 10;
        this.a = 200;
        System.out.println(t.a); // 메소드 내 t.a = 10 출력
    }

    public void test4(Test t) {
        t.a = 1000;
        System.out.println(this.a);
    }
}
