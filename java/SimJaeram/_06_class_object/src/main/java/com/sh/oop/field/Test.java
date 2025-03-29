package com.sh.oop.field;

public class Test {
    int a = 100;
    static int s = 99;

    public static void main(String[] args) {
        Test t = new Test();
        t.test1();                      // 100, 99 출력

        t.test2();                      // 1000 출력

        Test t3 = new Test();
        t.test3(t3);
        System.out.println(t3.a);


        t.test4(t);

    }

    public void test1() {
        int a = 1000;
        int s = 999;
        System.out.println(this.a);     // Test 클래스의 전역변수, 인스턴스 변수 a, 100
        System.out.println(Test.s);     // Test 클래스의 전역변수, 클래스 변수 s 99
    }

    public void test2() {
        Test t = new Test();            // test2() 메소드의 지역변수 t
        t.a = 1000;                     // 객체 t의 인스턴스 변수 a, 1000
        System.out.println(a);          // 1000 출력
    }

    public void test3(Test t) {
        t.a = 10;
        this.a = 200;
        System.out.println(t.a);
    }

    public void test4(Test t) {
        t.a = 1000;
        System.out.println(this.a);
    }

}