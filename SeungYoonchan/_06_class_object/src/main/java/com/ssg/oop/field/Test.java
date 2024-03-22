package com.ssg.oop.field;

public class Test {
    int a = 100;
    static int s = 99;

    public static void main(String[] args) {
        Test t = new Test();
        t.test1(); //100, 99
        System.out.println();

        t.test2(); // 출력: 100
        System.out.println();

        Test t3 = new Test();
        t.test3(t3); // 출력: 10
        System.out.println();

        System.out.println(t3.a); // 출력: 10
        System.out.println();

        t.test4(t); // 출력: 200
    }

    public void test1() {
        int a = 1000;
        int s = 999;
        System.out.println(this.a); // 출력: 100
        System.out.println(Test.s); // 출력: 99
    }

    public void test2() {
        Test t = new Test();
        t.a = 1000;
        System.out.println(a); // 출력: 100
    }

    public void test3(Test t) {
        t.a = 10;
        this.a = 200;
        System.out.println(t.a); // 출력: 10
    }

    public void test4(Test t) {
        t.a = 1000;
        System.out.println(this.a); // 출력: 1000
    }
}
