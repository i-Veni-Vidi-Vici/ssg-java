package com.ssg.oop.field;

public class Test {
    int a = 100; // 200
    static int s = 99;

    public static void main(String[] args) {
        Test t = new Test();
        t.test1();
        // 100
        // 99
        t.test2();
        // 100
        Test t3 = new Test();
        t.test3(t3);
        // 10
        System.out.println(t3.a);
        // 10
        t.test4(t);
        // 1000
    }

    public void test1() {
        int a = 1000;
        int s = 999;
        System.out.println(this.a); // t.test1 이므로 t.a는 초기값인 100
        System.out.println(Test.s); // 99
    }

    public void test2() {
        Test t = new Test();
        t.a = 1000; // 이 객체는 사라짐
        System.out.println(a); // 100
    }

    public void test3(Test t) { // test3(t3)
        t.a = 10; // t3.a = 10;
        this.a = 200; // Test 클래스의 a = 200
        System.out.println(t.a); // t3.a = 10;
    }

    public void test4(Test t) {
        t.a = 1000;
        System.out.println(this.a); // t.test4 이므로 t의 a는 1000
    }

}