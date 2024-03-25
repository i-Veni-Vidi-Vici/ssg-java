package com.ssg.oop.field;

/**
 * 다음 코드에서 각 출력문에 찍히게 될 값을 주석으로 작성하고, 실제 코드로 작성후 확인하세요.
 */
public class Test {
    int a = 200;
    static int s = 99;

    public static void main(String[] args) {
        Test t = new Test();
        t.test1(); // 100 // 99

        t.test2(); // 100

        Test t3 = new Test();
        t.test3(t3); // 10
        System.out.println(t3.a); // 10


        t.test4(t); // 1000

    }

    public void test1() {
        int a = 1000;
        int s = 999;
        System.out.println(this.a);
        System.out.println(Test.s);
    }

    public void test2() {
        Test t = new Test();
        t.a = 1000;
        System.out.println(a);
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
